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
    private TransportDAO instance;
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

    }

    public void dodajBus(ActionEvent actionEvent){

    }

}
