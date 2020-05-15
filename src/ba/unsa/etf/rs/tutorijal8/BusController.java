package ba.unsa.etf.rs.tutorijal8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BusController {
    public TextField fldProizv;
    public TextField fldSerija;
    public TextField brojSjedista;
    public Spinner brojVozaca;
    private Bus bus;
    public BusController(Bus bus) {
        this.bus = bus;
    }


    public Bus getBus() {
        return bus;
    }

    @FXML
    public void initialize() {
        if (bus != null) {
            fldProizv.setText(bus.getProizvodjac());
            fldSerija.setText(bus.getSerija());
            brojSjedista.setText(String.valueOf(bus.getNumberOfSeats()));
            brojVozaca.setPromptText(String.valueOf(bus.getNumberOfDrivers()));
        }
    }

    public void akcijaCancel(ActionEvent actionEvent) {
        bus = null;
        Stage stage = (Stage) fldSerija.getScene().getWindow();
        stage.close();
    }

    public void akcijaOk(ActionEvent actionEvent) {
        if (bus == null) bus = new Bus();
        bus.setProizvodjac(fldProizv.getText());
        bus.setSerija(fldSerija.getText());
        Stage stage = (Stage) fldProizv.getScene().getWindow();
        stage.close();
    }



}