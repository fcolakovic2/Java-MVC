package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {
    private SimpleIntegerProperty id=new SimpleIntegerProperty();
    private SimpleStringProperty proizvodjac=new SimpleStringProperty();
    private SimpleStringProperty serija=new SimpleStringProperty();
    private SimpleIntegerProperty numberOfSeats=new SimpleIntegerProperty();
    private SimpleObjectProperty<Driver> firstDriver=new SimpleObjectProperty<>();
    private SimpleObjectProperty<Driver> secondDriver=new SimpleObjectProperty<>();


    public Bus(){ }

    public Bus(String proizvodjac, String serija, int brojSjedista) {
        this.proizvodjac.set(proizvodjac);
        this.serija.set(serija);
        this.numberOfSeats.set(brojSjedista);
    }



    public Bus(int id, String proizvodjac, String serija, int numberOfSeats, Driver firstDriver, Driver secondDriver) {
        this.id=new SimpleIntegerProperty(id);
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija =new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.firstDriver =  new SimpleObjectProperty<Driver>(firstDriver);
        this.secondDriver = new SimpleObjectProperty<Driver>(secondDriver);
    }


    public Bus(String proizvodjac, String serija, int numberOfSeats, Driver firstDriver, Driver secondDriver) {
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija =new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.firstDriver =  new SimpleObjectProperty<Driver>(firstDriver);
        this.secondDriver = new SimpleObjectProperty<Driver>(secondDriver);
    }


    public Bus(SimpleStringProperty proizvodjac, SimpleStringProperty serija, SimpleIntegerProperty numberOfSeats, SimpleObjectProperty<Driver> firstDriver, SimpleObjectProperty<Driver> secondDriver) {
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.firstDriver = firstDriver;
        this.secondDriver = secondDriver;
    }

    public Bus(SimpleIntegerProperty id, SimpleStringProperty proizvodjac, SimpleStringProperty serija, SimpleIntegerProperty numberOfSeats, SimpleObjectProperty<Driver> firstDriver, SimpleObjectProperty<Driver> secondDriver) {
        this.id = id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.firstDriver = firstDriver;
        this.secondDriver = secondDriver;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getProizvodjac() {
        return proizvodjac.get();
    }

    public SimpleStringProperty proizvodjacProperty() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac.set(proizvodjac);
    }

    public String getSerija() {
        return serija.get();
    }

    public SimpleStringProperty serijaProperty() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija.set(serija);
    }

    public int getnumberOfSeats() {
        return numberOfSeats.get();
    }

    public SimpleIntegerProperty numberOfSeatsProperty() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats.set(numberOfSeats);
    }

    public Driver getFirstDriver() {
        return firstDriver.get();
    }

    public SimpleObjectProperty<Driver> firstDriverProperty() {
        return firstDriver;
    }

    public void setFirstDriver(Driver firstDriver) {
        this.firstDriver.set(firstDriver);
    }

    public Driver getSecondDriver() {
        return secondDriver.get();
    }

    public SimpleObjectProperty<Driver> secondDriverProperty() {
        return secondDriver;
    }

    public void setSecondDriver(Driver secondDriver) {
        this.secondDriver.set(secondDriver);
    }

    @Override
    public String toString() {
        return proizvodjac.get() + serija.get();
    }
}