module com.example.fxproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;
    requires AnimateFX;

    opens com.example.fxproject to javafx.fxml;
    exports com.example.fxproject;
}