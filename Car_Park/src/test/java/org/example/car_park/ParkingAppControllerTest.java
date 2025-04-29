package org.example.car_park;

import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAppControllerTest {
    private ParkingAppController controller;

    // Initialize JavaFX toolkit once before all tests
    @BeforeAll
    public static void initJFX() {
        Platform.startup(() -> {});
    }

    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> {
            controller = new ParkingAppController();
            controller.txt_DriverName = new TextField();
            controller.txt_LiscencePlate = new TextField();
            controller.SpaceComboBox = new ComboBox<>();
            controller.ConfirmationLabel = new Label();

            // Sample values for the ComboBox
            controller.SpaceComboBox.getItems().addAll("Space 1", "Space 2", "Space 3", "Space 4", "Space 5");
        });
    }



    @Test
    public void testReservation_MissingName() {
        Platform.runLater(() -> {
            controller.txt_DriverName.setText("");
            controller.txt_LiscencePlate.setText("XYZ123");
            controller.SpaceComboBox.setValue("Space 1");

            controller.Reservation();

            assertEquals("please enter a name, select a space and enter a valid license plate",
                    controller.ConfirmationLabel.getText());
        });
    }

    @Test
    public void testReservation_MissingLicensePlate() {
        Platform.runLater(() -> {
            // Set up test data - name provided but license plate missing
            controller.txt_DriverName.setText("Jane Smith");
            controller.txt_LiscencePlate.setText("");  // Empty license plate
            controller.SpaceComboBox.setValue("Space 2");  // Valid space selected

            // Execute the reservation method
            controller.Reservation();

            // Verify the error message
            assertEquals("please enter a name, select a space and enter a valid license plate",
                    controller.ConfirmationLabel.getText());
        });
    }

    @Test
    public void testComboBoxInitialization() {
        Platform.runLater(() -> {
            // Verify the combo box has all expected items
            assertFalse(controller.SpaceComboBox.getItems().isEmpty());
            assertEquals(5, controller.SpaceComboBox.getItems().size());
            assertTrue(controller.SpaceComboBox.getItems().contains("Space 1"));
            assertTrue(controller.SpaceComboBox.getItems().contains("Space 5"));
        });
    }

    @AfterEach
    public void tearDown() {
        Platform.runLater(() -> {
            // Clean up if needed
        });
    }
}