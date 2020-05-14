package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Driver {
    private SimpleIntegerProperty id;
    private SimpleStringProperty Ime, Prezime, JMB;
    private SimpleObjectProperty<LocalDate> dateOfBirth, dateOfEmployment;


    public Driver() {
        id=new SimpleIntegerProperty();
        Ime=new SimpleStringProperty();
        Prezime=new SimpleStringProperty();
        JMB=new SimpleStringProperty();
        dateOfBirth=new SimpleObjectProperty<LocalDate>();
        dateOfEmployment=new SimpleObjectProperty<LocalDate>();
    }

    public Driver(String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.Ime = new SimpleStringProperty(ime);
        Prezime = new SimpleStringProperty(prezime);
        this.JMB = new SimpleStringProperty(JMB);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.dateOfEmployment =new SimpleObjectProperty<LocalDate>(dateOfEmployment);
    }

    public Driver(int id , String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.id = new SimpleIntegerProperty(id);
        this.Ime = new SimpleStringProperty(ime);
        Prezime = new SimpleStringProperty(prezime);
        this.JMB = new SimpleStringProperty(JMB);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.dateOfEmployment = new SimpleObjectProperty<LocalDate>(dateOfEmployment);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return Ime.get();
    }

    public void setIme(String ime) {
        Ime.set(ime);
    }

    public String getPrezime() {
        return Prezime.get();
    }

    public void setPrezime(String prezime) {
        Prezime.set(prezime);
    }

    public String getJMB() {
        return JMB.get();
    }

    public void setJMB(String JMB) {
        this.JMB.set(JMB);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment.get();
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment.set(dateOfEmployment);
    }

    @Override
    public String toString() {
        return Ime+" " +Prezime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(getJMB(), driver.getJMB());
    }

}