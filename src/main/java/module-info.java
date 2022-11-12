module com.example.currencyconverterapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.currencyconverterapi to javafx.fxml;
    exports com.example.currencyconverterapi;
}