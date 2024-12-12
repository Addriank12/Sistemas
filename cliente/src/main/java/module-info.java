module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens com.example to javafx.fxml;
    opens models to com.fasterxml.jackson.databind, javafx.base;
    exports com.example;
}
