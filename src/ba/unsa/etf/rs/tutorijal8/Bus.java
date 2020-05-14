package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {
    private SimpleIntegerProperty id=new SimpleIntegerProperty();
    private SimpleStringProperty proizvodjac=new SimpleStringProperty();
    private SimpleStringProperty serija=new SimpleStringProperty();
    private SimpleIntegerProperty numberOfSeats=new SimpleIntegerProperty();
    private SimpleIntegerProperty firstDriver =new SimpleIntegerProperty();
    private SimpleIntegerProperty secondDriver=new SimpleIntegerProperty();


    public Bus(){ }

    public Bus(String proizvodjac, String serija, int numberOfSeats, int firstDriver, int secondDriver) {
        this.proizvodjac = new SimpleStringProperty(proizvodjac);
        this.serija =new SimpleStringProperty(serija);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.firstDriver =  new SimpleIntegerProperty(firstDriver);
        this.secondDriver =  new SimpleIntegerProperty(secondDriver);
    }


    public Bus(SimpleStringProperty proizvodjac, SimpleStringProperty serija, SimpleIntegerProperty numberOfSeats, SimpleIntegerProperty firstDriver, SimpleIntegerProperty secondDriver) {
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.firstDriver = firstDriver;
        this.secondDriver = secondDriver;
    }

    public Bus(SimpleIntegerProperty id, SimpleStringProperty proizvodjac, SimpleStringProperty serija, SimpleIntegerProperty numberOfSeats, SimpleIntegerProperty firstDriver, SimpleIntegerProperty secondDriver) {
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

    public int getNumberOfSeats() {
        return numberOfSeats.get();
    }

    public SimpleIntegerProperty numberOfSeatsProperty() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats.set(numberOfSeats);
    }

    public int getFirstDriver() {
        return firstDriver.get();
    }

    public SimpleIntegerProperty firstDriverProperty() {
        return firstDriver;
    }

    public void setFirstDriver(int firstDriver) {
        this.firstDriver.set(firstDriver);
    }

    public int getSecondDriver() {
        return secondDriver.get();
    }

    public SimpleIntegerProperty secondDriverProperty() {
        return secondDriver;
    }

    public void setSecondDriver(int secondDriver) {
        this.secondDriver.set(secondDriver);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", proizvodjac=" + proizvodjac +
                ", serija=" + serija +
                ", numberOfSeats=" + numberOfSeats +
                ", firstDriver=" + firstDriver +
                ", secondDriver=" + secondDriver +
                '}';
    }
}