module com.example.fxproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.fxproject to javafx.fxml;
    exports com.example.fxproject;
}