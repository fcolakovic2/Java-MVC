package ba.unsa.etf.rs.tutorijal8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Driver {
    private SimpleIntegerProperty id=new SimpleIntegerProperty();
    private SimpleStringProperty Ime=new SimpleStringProperty();
    private SimpleStringProperty Prezime=new SimpleStringProperty();
    private SimpleStringProperty JMB = new SimpleStringProperty();
    private SimpleObjectProperty<LocalDate> dateOfBirth=new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> dateOfEmployment=new SimpleObjectProperty<>();

    public Driver() { }

    public Driver(String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.Ime = new SimpleStringProperty(ime);
        Prezime = new SimpleStringProperty(prezime);
        this.JMB = new SimpleStringProperty(JMB);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.dateOfEmployment = new SimpleObjectProperty<LocalDate>(dateOfEmployment);
    }


    public Driver(int id, String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.id=new SimpleIntegerProperty(id);
        this.Ime = new SimpleStringProperty(ime);
        Prezime = new SimpleStringProperty(prezime);
        this.JMB = new SimpleStringProperty(JMB);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.dateOfEmployment = new SimpleObjectProperty<LocalDate>(dateOfEmployment);
    }

    public Driver(SimpleStringProperty ime, SimpleStringProperty prezime, SimpleStringProperty JMB, SimpleObjectProperty<LocalDate> dateOfBirth, SimpleObjectProperty<LocalDate> dateOfEmployment) {
        Ime = ime;
        Prezime = prezime;
        this.JMB = JMB;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Driver(SimpleIntegerProperty id, SimpleStringProperty ime, SimpleStringProperty prezime, SimpleStringProperty JMB, SimpleObjectProperty<LocalDate> dateOfBirth, SimpleObjectProperty<LocalDate> dateOfEmployment) {
        this.id = id;
        Ime = ime;
        Prezime = prezime;
        this.JMB = JMB;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
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

    public String getName() {
        return Ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return Ime;
    }

    public void setIme(String ime) {
        this.Ime.set(ime);
    }

    public String getPrezime() {
        return Prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        this.Prezime.set(prezime);
    }

    public String getJMB() {
        return JMB.get();
    }

    public SimpleStringProperty JMBProperty() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB.set(JMB);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfEmploymentProperty() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment.set(dateOfEmployment);
    }

    @Override
    public String toString() {
        return Ime.get();
    }
}