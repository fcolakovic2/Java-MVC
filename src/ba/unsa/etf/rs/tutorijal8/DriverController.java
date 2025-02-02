package ba.unsa.etf.rs.tutorijal8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DriverController {
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldJMBG;
    public DatePicker fldDateOfBirth;
    public DatePicker fldDateOfEmployment;
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public DriverController(Driver driver) {
        this.driver = driver;
    }

    @FXML
    public void initialize() {
        if (driver != null) {
            fldIme.setText(driver.getIme());
            fldPrezime.setText(driver.getPrezime());

        }
    }

    public void akcijaCancel(ActionEvent actionEvent) {
        driver = null;
        Stage stage = (Stage) fldPrezime.getScene().getWindow();
        stage.close();
    }

    public void akcijaOk(ActionEvent actionEvent) {
        if (driver == null) driver = new Driver();
        driver.setIme(fldIme.getText());
        driver.setPrezime(fldPrezime.getText());
        driver.setJMB(fldJMBG.getText());
        driver.setBirthDate(fldDateOfBirth.getValue());
        driver.setWorkDate(fldDateOfEmployment.getValue());
        Stage stage = (Stage) fldJMBG.getScene().getWindow();
        stage.close();
    }

}