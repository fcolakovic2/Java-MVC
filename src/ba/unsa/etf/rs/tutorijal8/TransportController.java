package ba.unsa.etf.rs.tutorijal8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TransportController {

    public Button btnExit;
    public ListView<Driver> listaVozaca;
    public ListView<Bus> listaBuseva;
    public Label labelaValidacija;
    private TransportDAO instance=TransportDAO.getInstance();
    private TextField textFieldVoz;
    private TextField textFieldBus;


    public TransportController(TransportDAO instance) {
        this.instance = instance;
    }


    @FXML
    public void initialize(){
        Driver driver = new Driver("ja","ti","111", LocalDate.now(), LocalDate.now());
        instance.getDrivers().add(driver);
        instance.getDrivers().clear();
        listaVozaca.setItems(instance.getDrivers());
        listaBuseva.setItems(instance.getBusses());
    }

    public void exitBtn(ActionEvent actionEvent) {
      Stage gasi=(Stage) listaBuseva.getScene().getWindow();
      gasi.close();
    }


    public void dodajVozaca(ActionEvent actionEvent){
        boolean status = instance.addDriver(new Driver(textFieldVoz.getText()));
        if (status) {
            instance.getDrivers();
            labelaValidacija.setText("Uspješno dodan vozač!");
        } else labelaValidacija.setText("Došlo je do greške pri dodavanju vozača!");
    }

    public void dodajBus(ActionEvent actionEvent){
        String proizv=textFieldBus.getText();
        Bus bus = new Bus(proizv,"serija",50);
        boolean status = instance.addBus(bus);
        if (status) {
            instance.getBusses();
            labelaValidacija.setText("Uspješno dodan autobus!");
        } else labelaValidacija.setText("Došlo je do greške pri dodavanju autobusa!");
    }

}
