package ba.unsa.etf.rs.tutorijal8;

public class Bus {
    private Integer id = null;
    private String proizvodjac;
    private String serija;
    private int numberOfSeats;
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

    public String getMaker() {
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

    public int getSeatNumber() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }



    @Override
    public String toString () {
        String s = "";
        s += this.proizvodjac + " " + this.serija + " ( seats: " + this.getSeatNumber() + " )";
        if (firstDriver != null) {
            s += firstDriver.toString();
        }
        if (secondDriver != null) {
            s += secondDriver.toString();
        }
        return s;
    }

}