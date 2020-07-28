module EdenCoding.JavaFX.Animation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.edencoding.controllers to javafx.fxml;

    exports com.edencoding;
}