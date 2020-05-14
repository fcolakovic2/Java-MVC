package ba.unsa.etf.rs.tutorijal8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TransportController {
    public ListView listaBuseva;
    public ListView listaVozaca;
    private TransportDAO dao;
    public Button napustiDugme;
    public Button potvrdaButton;
    public TextField imeBusa;


    @FXML
    public void initialize(){
      dao=TransportDAO.getInstance();
      listaBuseva.setItems(dao.vratiSveBuseve());
    }

    public void napustiDugme(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void potvrdiIzmjene(ActionEvent actionEvent) {
    }
}
