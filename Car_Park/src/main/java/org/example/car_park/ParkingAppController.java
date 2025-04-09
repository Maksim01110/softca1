package org.example.car_park;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkingAppController {

    @FXML
    TextField txt_LiscencePlate;

    @FXML
    TextField txt_DriverName;

    @FXML
    Label ConfirmationLabel;

    @FXML
    ComboBox<String> SpaceComboBox;

    private String[] Spaces = {"Space 1", "Space 2", "Space 3", "Space 4", "Space 5"};

    @FXML
public void initialize(){
        //populate the combo box with parking space numbers
        SpaceComboBox.getItems().addAll(Spaces);
    }

public void Reservation() {
        String Name = txt_DriverName.getText();
        String Space = SpaceComboBox.getValue();
        String Liscence = txt_LiscencePlate.getText();

        if (Space == null || Name.equals("") || Liscence.equals("")) {
            ConfirmationLabel.setText("please enter a name, select a space and enter a valid liscence plate");
        }
        else {
            String message = "Reservation for " + Name + ", " + Space + ", " + Liscence;
            ConfirmationLabel.setText(message);
        }
}
}
