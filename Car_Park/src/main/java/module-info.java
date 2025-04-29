module org.example.car_park {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.car_park to javafx.fxml;
    exports org.example.car_park;
}