package org.example.car_park;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class ParkingAppControllerTest {
    private ParkingAppController controller;   //creates variable controller that can be used by all test methods

    @BeforeEach
    public void setUp() {
        controller = new ParkingAppController();
        controller.txt_DriverName = new TextField();
        controller.txt_LiscencePlate = new TextField();
        controller.SpaceComboBox = new ComboBox<>();
        controller.ConfirmationLabel = new Label();

        // Sample values for the ComboBox
        controller.SpaceComboBox.getItems().addAll("Space 1", "Space 2", "Space 3", "Space 4", "Space 5");
    }

    @Test
    public void testReservation_AllFieldsValid() {
        controller.txt_DriverName.setText("John Doe");
        controller.txt_LiscencePlate.setText("XYZ123");
        controller.SpaceComboBox.setValue("A1");

        controller.Reservation();

        assertEquals("Reservation for John Doe, A1, XYZ123", controller.ConfirmationLabel.getText());
    }

    @Test
    public void testReservation_MissingName() {
        controller.txt_DriverName.setText("");
        controller.txt_LiscencePlate.setText("XYZ123");
        controller.SpaceComboBox.setValue("A1");

        controller.Reservation();

        assertEquals("please enter a name, select a space and enter a valid liscence plate", controller.ConfirmationLabel.getText());
    }


}