package ba.unsa.etf.rs.tutorijal8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TransportController {
    public Button btnExit;
    public ListView<Driver> listaVozaca;
    public ListView<Bus> listaBuseva;

    @FXML
    public void initialize(){
    }

    public void exitBtn(ActionEvent actionEvent) {
      Stage gasi=(Stage) listaBuseva.getScene().getWindow();
      gasi.close();
    }


    public void dodajVozaca(ActionEvent actionEvent){

    }

}
