package ba.unsa.etf.rs.tutorijal8;

import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Driver {
    private Integer id;
    private String Ime;
    private String Prezime;
    private String JMB;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;

    public Driver() { }

    public Driver(String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.Ime = ime;
        Prezime = prezime;
        this.JMB = JMB;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Driver(int id , String ime, String prezime, String JMB, LocalDate dateOfBirth, LocalDate dateOfEmployment) {
        this.id = id;
        this.Ime = ime;
        Prezime = prezime;
        this.JMB = JMB;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
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