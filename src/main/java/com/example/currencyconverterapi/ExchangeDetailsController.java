package com.example.currencyconverterapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExchangeDetailsController {

    @FXML
    private Label amountLabel;

    @FXML
    private Label rateLabel;

    @FXML
    private Button returnButton;

    @FXML
    private Label totalLabel;

    @FXML
    void viewConverter(ActionEvent event) throws IOException { //view converter button to switch scenes
        Parent root = FXMLLoader.load(getClass().getResource("converter-view.fxml"));

        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root)); //no size
    }

    public void getConverterDetails(int amount, String currencyFrom, String currencyTo) throws IOException, InterruptedException {
        amountLabel.setVisible(false);
        rateLabel.setVisible(false);
        totalLabel.setVisible(false);

        //validation
        amountLabel.setText("");
        rateLabel.setText("");
        totalLabel.setText("");

        APIResponse apiResponse = APIUtility.getConverterFromRapidAPI(amount, currencyFrom, currencyTo);
        CountryCode countryCode = apiResponse.getRates();
        Converter converter = countryCode.allCountryCodes(currencyTo);

        double rate2 = converter.getRate();

        double finalAmount = amount * rate2;

        amountLabel.setText(String.valueOf(amount));
        rateLabel.setText(String.valueOf(rate2));
        totalLabel.setText(String.valueOf(finalAmount));


        if(amountLabel.getText().isBlank() || rateLabel.getText().isBlank() || totalLabel.getText().isBlank()){
            amountLabel.setText("Invalid");
            rateLabel.setText("Invalid");
            totalLabel.setText("Invalid");
            amountLabel.setVisible(true);
            rateLabel.setVisible(true);
            totalLabel.setVisible(true);
        }
        else {
            amountLabel.setVisible(true);
            rateLabel.setVisible(true);
            totalLabel.setVisible(true);
        }
    }
}


