package ba.unsa.etf.rs.tutorijal8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        TransportDAO transDAO = TransportDAO.getInstance();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/baza.fxml"));
        loader.setController(new TransportController(transDAO));
        primaryStage.setTitle("Tutorijal 8");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(loader.load(), 500, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
