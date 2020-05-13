package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty proizvodjac = new SimpleStringProperty();
    private SimpleStringProperty serija = new SimpleStringProperty();
    private SimpleIntegerProperty numberOfSeats = new SimpleIntegerProperty();
    private SimpleIntegerProperty brojVozaca = new SimpleIntegerProperty();
    private SimpleIntegerProperty FirstDriver = new SimpleIntegerProperty();
    private SimpleIntegerProperty SecondDriver = new SimpleIntegerProperty();

    public Bus() {
    }

    public Bus(SimpleIntegerProperty id, SimpleStringProperty proizvodjac, SimpleStringProperty serija, SimpleIntegerProperty numberOfSeats, SimpleIntegerProperty brojVozaca, SimpleIntegerProperty firstDriver, SimpleIntegerProperty secondDriver) {
        this.id = id;
        this.proizvodjac = proizvodjac;
        this.serija = serija;
        this.numberOfSeats = numberOfSeats;
        this.brojVozaca = brojVozaca;
        FirstDriver = firstDriver;
        SecondDriver = secondDriver;
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

    public int getBrojVozaca() {
        return brojVozaca.get();
    }

    public SimpleIntegerProperty brojVozacaProperty() {
        return brojVozaca;
    }

    public void setBrojVozaca(int brojVozaca) {
        this.brojVozaca.set(brojVozaca);
    }

    public int getFirstDriver() {
        return FirstDriver.get();
    }

    public SimpleIntegerProperty firstDriverProperty() {
        return FirstDriver;
    }

    public void setFirstDriver(int firstDriver) {
        this.FirstDriver.set(firstDriver);
    }

    public int getSecondDriver() {
        return SecondDriver.get();
    }

    public SimpleIntegerProperty secondDriverProperty() {
        return SecondDriver;
    }

    public void setSecondDriver(int secondDriver) {
        this.SecondDriver.set(secondDriver);
    }

    @Override
    public String toString() {
        return proizvodjac.get();
}