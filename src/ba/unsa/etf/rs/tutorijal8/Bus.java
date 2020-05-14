package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {
    private SimpleIntegerProperty id, numberOfSeats;
    private SimpleStringProperty proizvodjac,serija;
    private SimpleObjectProperty<Driver> firstDriver, secondDriver;


    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats.get();
    }

    public SimpleIntegerProperty numberOfSeatsProperty() {
        return numberOfSeats;
    }

    public SimpleStringProperty proizvodjacProperty() {
        return proizvodjac;
    }

    public SimpleStringProperty serijaProperty() {
        return serija;
    }

    public SimpleObjectProperty<Driver> firstDriverProperty() {
        return firstDriver;
    }

    public SimpleObjectProperty<Driver> secondDriverProperty() {
        return secondDriver;
    }

    public Driver getFirstDriver() {
        return firstDriver.get();
    }

    public void setFirstDriver(Driver firstDriver) {
        this.firstDriver.set(firstDriver);
    }

    public Driver getSecondDriver() {
        return secondDriver.get();
    }

    public void setSecondDriver(Driver secondDriver) {
        this.secondDriver.set(secondDriver);
    }

    public Bus(){
        id=new SimpleIntegerProperty();
        numberOfSeats=new SimpleIntegerProperty();
        proizvodjac=new SimpleStringProperty();
        serija=new SimpleStringProperty();
        firstDriver=new SimpleObjectProperty<Driver>();
        secondDriver=new SimpleObjectProperty<Driver>();
    }

    public Bus(String proizvodjac, String serija, int numberOfSeats) {
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija = new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
    }

    public Bus( int Id, String proizvodjac, String serija, int numberOfSeats) {
        id = new SimpleIntegerProperty(Id);
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija = new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);

    }
    public Bus(int Id, String proizvodjac, String serija, int numberOfSeats, Driver driverPrvi, Driver driverDrugi) {
        id = new SimpleIntegerProperty(Id);
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija = new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.firstDriver = new SimpleObjectProperty<Driver>(driverPrvi);
        this.secondDriver = new SimpleObjectProperty<Driver>(driverDrugi);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getProizvodjac() {
        return proizvodjac.get();
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac.set(proizvodjac);
    }

    public String getSerija() {
        return serija.get();
    }

    public void setSerija(String serija) {
        this.serija.set(serija);
    }

    public int getnumberOfSeats() {
        return numberOfSeats.get();
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats.set(numberOfSeats);
    }



    @Override
    public String toString () {
        return proizvodjac.get();
    }

}