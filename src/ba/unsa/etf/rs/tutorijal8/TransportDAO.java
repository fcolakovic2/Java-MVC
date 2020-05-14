package ba.unsa.etf.rs.tutorijal8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.sqlite.JDBC;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransportDAO {
    private static TransportDAO instance;
    private Connection conn;  //def konekcije
    private ObservableList<Driver> sviDriveri = FXCollections.observableArrayList();
    private ObservableList<Bus> buses = FXCollections.observableArrayList();

    private static PreparedStatement obrisiTrenutnogVozacaUpit, vratiSveVozaceUpit, vratiSveBuseveUpit, obrisiDodjeluVozacaUpit, ubaciuDodjeluUpit, vratiNarBusUpit, vratiNarDriveraUpit, obrisiSveDodjeleUpit, ubaciUDriveraUpit, obrisiTrenutniBusUpit, obrisiSveBuseveUpit, obrisiDodjeluBusaUpit,
            ubaciuBusUpit, obrisiSveVozaceUpit, vratiVozaceDodijeljeneUpit;   //def upita

    public static TransportDAO getInstance() {
        if(instance == null) instance = new TransportDAO();   //napravi instancu, vrati je
        return instance;
    }
    static {
        try {
            DriverManager.registerDriver(new JDBC());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TransportDAO(){     //zabranjen konstruktor, ne moze se transport instancirat
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Baza.db");   //conn na bazu
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ubaciuBusUpit = conn.prepareStatement("INSERT INTO Bus VALUES(?,?,?,?)");
            ubaciUDriveraUpit = conn.prepareStatement("INSERT INTO Vozac VALUES (?,?,?,?,?,?)");
            ubaciuDodjeluUpit = conn.prepareStatement("INSERT OR REPLACE INTO dodjela(bus_id, driver_id) VALUES (?,?)");
            obrisiSveDodjeleUpit = conn.prepareStatement("DELETE FROM dodjela WHERE 1=1;");
            obrisiTrenutnogVozacaUpit = conn.prepareStatement("DELETE FROM Vozac WHERE  vozac_id=?");         //svi upiti
            obrisiDodjeluBusaUpit = conn.prepareStatement("DELETE FROM dodjela WHERE bus_id = ?");
            obrisiSveBuseveUpit = conn.prepareStatement("DELETE FROM Bus");
            obrisiTrenutniBusUpit = conn.prepareStatement("DELETE FROM Bus WHERE bus_id=?");
            obrisiSveVozaceUpit = conn.prepareStatement("DELETE FROM Vozac");
            vratiVozaceDodijeljeneUpit = conn.prepareStatement("SELECT DISTINCT dr.vozac_id, dr.ime, dr.prezime, dr.JMB, dr.datum_rodjenja, dr.datum_zaposlenja" +
                    " FROM dodjela d INNER JOIN Vozac dr ON (d.driver_id = dr.vozac_id) WHERE d.bus_id=?");
            vratiSveVozaceUpit = conn.prepareStatement("SELECT * FROM Vozac;");
            vratiSveBuseveUpit = conn.prepareStatement("SELECT * FROM Bus");
            vratiNarDriveraUpit = conn.prepareStatement("SELECT MAX(vozac_id)+1 FROM Vozac");
            vratiNarBusUpit = conn.prepareStatement("SELECT MAX(bus_id)+1 FROM Bus");
            obrisiDodjeluVozacaUpit = conn.prepareStatement("DELETE FROM dodjela WHERE driver_id = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void resetDatabase() {
        try {
            obrisiSveVozaceUpit.executeUpdate();
            obrisiSveBuseveUpit.executeUpdate();
            obrisiSveDodjeleUpit.executeUpdate();             //resetuje se tako sto pobrisemo sve iz nje
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ObservableList<Driver> getDrivers() {
        ResultSet sviVozaci = null;
        try {
            sviVozaci = vratiSveVozaceUpit.executeQuery();
            Driver driver;
            while ((driver = dajVozaceUpit(sviVozaci))!=null)   //samo vratit sve drivere iz querya
            {
                sviDriveri.add(driver);
            }
            sviVozaci.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sviDriveri;
    }

    public void addDriver(Driver driver){
        ObservableList<Driver> listDrivera = getDrivers();
        if(listDrivera.contains(driver)) {
            throw new IllegalArgumentException("Taj vozač već postoji!");
        }                 //vraceni svi dosadasnji driveri, provjera da li postoji vozac koji se unosi

        try {
            ResultSet driveri = vratiNarDriveraUpit.executeQuery();
            int id = 1;
            if (driveri.next()) {
                id = driveri.getInt(1);
            }
            ubaciUDriveraUpit.setInt(1, id);
            ubaciUDriveraUpit.setString(2, driver.getName());    //popunjavanje upita
            ubaciUDriveraUpit.setString(3, driver.getPrezime());
            ubaciUDriveraUpit.setString(4 , driver.getJMB());
            ubaciUDriveraUpit.setDate(5 , Date.valueOf((driver.getDateOfBirth())));  //konverzija u obicni Date jer getDateOfBirth vraca LocalDate
            ubaciUDriveraUpit.setDate(6 , Date.valueOf((driver.getDateOfEmployment())));
            ubaciUDriveraUpit.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Taj vozač već postoji!");
        }
    }


    public void addBus(Bus bus) {
        try {
            ResultSet busevi = vratiNarBusUpit.executeQuery();
            int id = 1;
            if (busevi.next()) id = busevi.getInt(1);
            ubaciuBusUpit.setInt(1, id);
            ubaciuBusUpit.setString(2, bus.getProizvodjac());
            ubaciuBusUpit.setString(3, bus.getSerija());  //popunjavanje upita za bus
            ubaciuBusUpit.setInt(4, bus.getnumberOfSeats());
            ubaciuBusUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<Bus> getBusses() {
        try {
            ResultSet busevi = vratiSveBuseveUpit.executeQuery();
            while(busevi.next()) {
                Integer id = busevi.getInt(1);
                String proizvodjac = busevi.getString(2);
                String serija = busevi.getString(3);
                int brojSjedista = busevi.getInt(4);
                vratiVozaceDodijeljeneUpit.setInt(1, id);

                ResultSet vozaci = vratiVozaceDodijeljeneUpit.executeQuery();
                Driver driver;
                ArrayList<Driver> drivers = new ArrayList<Driver>();
                while (vozaci.next()) {
                    Integer id_drivera = vozaci.getInt(1);
                    String name = vozaci.getString(2);
                    String surname = vozaci.getString(3);
                    String jmb = vozaci.getString(4);
                    Date dateOfBirth = vozaci.getDate(5);
                    Date dateOfEmployment = vozaci.getDate(6);
                    drivers.add(new Driver(id_drivera, name, surname, jmb, dateOfBirth.toLocalDate(), dateOfEmployment.toLocalDate()));
                }
                if (drivers.size() == 1) buses.add(new Bus(id, proizvodjac, serija, brojSjedista, drivers.get(0), null));

                else if (drivers.size() == 2) buses.add(new Bus(id, proizvodjac, serija, brojSjedista, drivers.get(0), drivers.get(1)));

                else buses.add(new Bus(id, proizvodjac, serija, brojSjedista, null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }

    private Driver dajVozaceUpit(ResultSet resultset) {
        Driver driver = null;
        try {
            if (resultset.next() ){
                int id = resultset.getInt("vozac_id");
                String name = resultset.getString("ime");
                String surname = resultset.getString("prezime");
                String jmb = resultset.getString("JMB");
                LocalDate dateOfBirth = (resultset.getDate("datum_rodjenja")).toLocalDate();
                LocalDate dateOfEmployment = (resultset.getDate("datum_zaposlenja")).toLocalDate();

                driver = new Driver( name , surname , jmb , dateOfBirth , dateOfEmployment);
                driver.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void deleteDriver(Driver driver) {
        try {
            obrisiTrenutnogVozacaUpit.setInt(1, driver.getId());
            obrisiTrenutnogVozacaUpit.executeUpdate();
            obrisiDodjeluVozacaUpit.setInt(1, driver.getId());
            obrisiDodjeluVozacaUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void dodijeliVozacuAutobus(Driver driver, Bus bus, int which) {
        try {
            ubaciuDodjeluUpit.setInt(1 , bus.getId());
            ubaciuDodjeluUpit.setInt(2,driver.getId());
            ubaciuDodjeluUpit.executeUpdate();
            if(which == 1){
                bus.setFirstDriver(driver);
            }
            if (which == 2){
                bus.setSecondDriver(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBus(Bus bus) {
        try {
            obrisiDodjeluBusaUpit.setInt(1, bus.getId());
            obrisiDodjeluBusaUpit.executeUpdate();
            obrisiTrenutniBusUpit.setInt(1, bus.getId());
            obrisiTrenutniBusUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}