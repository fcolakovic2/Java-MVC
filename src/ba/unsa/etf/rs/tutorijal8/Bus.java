package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {
    private SimpleIntegerProperty id=new SimpleIntegerProperty();
    private SimpleStringProperty proizvodjac=new SimpleStringProperty();
    private SimpleStringProperty serija=new SimpleStringProperty();
    private SimpleIntegerProperty numberOfSeats=new SimpleIntegerProperty();
    private Driver firstDriver = null;
    private Driver secondDriver = null;

    public Driver getFirstDriver() {
        return firstDriver;
    }

    public void setFirstDriver(Driver firstDriver) {
        this.firstDriver = firstDriver;
    }

    public Driver getSecondDriver() {
        return secondDriver;
    }

    public void setSecondDriver(Driver secondDriver) {
        this.secondDriver = secondDriver;
    }

    public Bus(){ }

    public Bus(String proizvodjac, String serija, int numberOfSeats) {
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
    }

    public Bus( int Id, String proizvodjac, String serija, int numberOfSeats) {
        id = Id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;

    }
    public Bus(int Id, String proizvodjac, String serija, int numberOfSeats, Driver driverPrvi, Driver driverDrugi) {
        id = Id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.firstDriver = driverPrvi;
        this.secondDriver = driverDrugi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getSerija() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija = serija;
    }

    public int getnumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }



    @Override
    public String toString () {
        String s = "";
        s += this.proizvodjac + " " + this.serija + " ( seats: " + this.getnumberOfSeats() + " )";
        if (firstDriver != null) {
            s += firstDriver.toString();
        }
        if (secondDriver != null) {
            s += secondDriver.toString();
        }
        return s;
    }

}