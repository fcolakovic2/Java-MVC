package ba.unsa.etf.rs.tutorijal8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class mainController {
    public TableView<Driver> tabelaDriver;
    public TableColumn<Driver , String> imeDrivera;
    public TableColumn<Driver , String> prezimeDrivera;
    public Label labelaVal;
    public TableView<Bus> tabelaBus;
    public TableColumn<Bus , String> makerBus;
    public TableColumn<Bus , String> serijaBus;

    private TransportDAO dao;
    private ObservableList<Driver> listaVozaca;
    private ObservableList<Bus> listaBuseva;

    public mainController() {
        dao = TransportDAO.getInstance();
        listaVozaca = FXCollections.observableArrayList(dao.getDrivers());
        listaBuseva = FXCollections.observableArrayList(dao.getBusses());
    }

    @FXML
    public void initialize() {
        tabelaDriver.setItems(listaVozaca);
        imeDrivera.setCellValueFactory(new PropertyValueFactory<>("Ime"));
        prezimeDrivera.setCellValueFactory(new PropertyValueFactory<>("Prezime"));
        labelaVal.setText("");
        tabelaBus.setItems(listaBuseva);
        makerBus.setCellValueFactory(new PropertyValueFactory<>("proizvodjac"));
        serijaBus.setCellValueFactory(new PropertyValueFactory<>("serija"));
    }

    public void setajText(){
        labelaVal.setText("Uspješno ste dodali novu instancu u tabelu");
    }

    public void dodajVozaca(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/driver.fxml"));
            DriverController driverController = new DriverController(null);
            loader.setController(driverController);
            root = loader.load();
            stage.setTitle("Drivers");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Driver driva = driverController.getDriver();
                if (driva != null) {
                    dao.addDriver(driva);
                    listaVozaca.setAll(dao.getDrivers());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exitBtn(ActionEvent actionEvent){
        System.exit(0);
    }

    public void dodajBus(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bus.fxml"));
            BusController busController = new BusController(null);
            loader.setController(busController);
            root = loader.load();
            stage.setTitle("Bus");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Bus bus = busController.getBus();
                if (bus != null) {
                    dao.addBus(bus);
                    listaBuseva.setAll(dao.getBusses());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void obrisiVozaca(ActionEvent actionEvent) {
        Driver vozac = tabelaDriver.getSelectionModel().getSelectedItem();
        if (vozac == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrdi");
        alert.setHeaderText("Brisanje vozača "+vozac.getIme());
        alert.setContentText("Da li želite izbrisati vozača " +vozac.getIme()+" "+vozac.getPrezime()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.deleteDriver(vozac);
            listaVozaca.setAll(dao.getDrivers());
        }
    }

    public void izbrisiBus(ActionEvent actionEvent) {
        Bus bus = tabelaBus.getSelectionModel().getSelectedItem();
        if (bus == null) return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Potvrdi");
        alert.setHeaderText("Brisanje autobusa "+bus.getProizvodjac());
        alert.setContentText("Da li želite izbrisati autobus " +bus.getProizvodjac()+" "+bus.getSerija()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dao.deleteBus(bus);
            listaBuseva.setAll(dao.getBusses());
        }
    }

    public void resetujBazu() {
        TransportDAO.removeInstance();
        File dbfile = new File("Baza.db");
        dbfile.delete();
        dao = TransportDAO.getInstance();
    }

    public void akcijaEditDrivera(ActionEvent actionEvent) {
        Driver driver = tabelaDriver.getSelectionModel().getSelectedItem();
        if (driver == null) return;

        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/driver.fxml"));
            DriverController driverController = new DriverController(driver);
            loader.setController(driverController);
            root = loader.load();
            stage.setTitle("Promjena podataka");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Driver driver1 = driverController.getDriver();
                if (driver1 != null) {
                    dao.izmijeniDrivera(driver1);
                    listaVozaca.setAll(dao.getDrivers());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void akcijaEditBus(ActionEvent actionEvent) {
        Bus bus = tabelaBus.getSelectionModel().getSelectedItem();
        if (bus == null) return;

        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bus.fxml"));
            BusController busController = new BusController(bus);
            loader.setController(busController);
            root = loader.load();
            stage.setTitle("Bus");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

            stage.setOnHiding( event -> {
                Bus bus1 = busController.getBus();
                if (bus1 != null) {
                    dao.izmijeniBus(bus1);
                    listaBuseva.setAll(dao.getBusses());
                }
            } );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}