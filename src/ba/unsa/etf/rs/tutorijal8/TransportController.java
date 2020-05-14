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
    public TextField imeVozaca;
    private TransportDAO dao;
    public Button napustiDugme;
    public Button potvrdaButton;
    public TextField imeBusa;


    @FXML
    public void initialize(){
      dao=TransportDAO.getInstance();
      listaBuseva.setItems(dao.vratiSveBuseve());
      listaVozaca.setItems(dao.vratiSveDrivere());

      listaVozaca.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, newItem) ->{
          Driver oldDriver=(Driver) oldItem;
          Driver newDriver=(Driver) newItem;
          if (oldItem!=null){
              imeVozaca.textProperty().unbindBidirectional(oldDriver.imeProperty());
          }
          if (newItem!=null){
              imeVozaca.textProperty().bindBidirectional(newDriver.imeProperty());
          }
          else{
              imeBusa.setText("");
          }
      });


      listaBuseva.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, newItem) ->{
          Bus oldBus= (Bus) oldItem;
          Bus newBus= (Bus) newItem;
          if (oldItem!=null){
              imeBusa.textProperty().unbindBidirectional(oldBus.proizvodjacProperty());
          }
          if (newItem!=null){
              imeBusa.textProperty().bindBidirectional(newBus.proizvodjacProperty());
          }
          else{
              imeBusa.setText("");
          }

      });
    }

    public void napustiDugme(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void potvrdiIzmjene(ActionEvent actionEvent) {
    }
}
