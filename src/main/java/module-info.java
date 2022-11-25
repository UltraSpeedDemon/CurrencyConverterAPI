module com.example.currencyconverterapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.currencyconverterapi to javafx.fxml, com.google.gson;
    exports com.example.currencyconverterapi;
}