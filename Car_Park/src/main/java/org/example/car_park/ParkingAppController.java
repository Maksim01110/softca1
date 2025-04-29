package org.example.car_park;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkingAppController {

    @FXML
    public TextField txt_LiscencePlate;

    @FXML
    public TextField txt_DriverName;

    @FXML
    public ListView<String> reservedListView;


    @FXML
    public Label ConfirmationLabel;

    @FXML
    public ComboBox<String> SpaceComboBox;

    private String[] Spaces = {"Space 1", "Space 2", "Space 3", "Space 4", "Space 5"};

    @FXML
    public void initialize(){
        //populate the combo box with parking space numbers
        SpaceComboBox.getItems().addAll(Spaces);
    }

    @FXML
    public void Reservation() {
        String name = txt_DriverName.getText();
        String space = SpaceComboBox.getValue();
        String licence = txt_LiscencePlate.getText();

        if (space == null || name.isEmpty() || licence.isEmpty()) {
            ConfirmationLabel.setText("Please enter a name, select a space, and enter a valid license plate.");
        } else {
            // Create the reservation message
            String message = "Reservation for " + name + ", " + space + ", " + licence;
            ConfirmationLabel.setText(message);

            // Add the reservation message to the ListView
            reservedListView.getItems().add(message);
        }
    }
}
