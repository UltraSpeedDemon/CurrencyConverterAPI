package com.example.currencyconverterapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class ConverterViewContoller implements Initializable {

    @FXML
    private TextField amountTextField;

    @FXML
    private Button convertButton;

    @FXML
    private ComboBox<String> currencyFromComboBox;

    @FXML
    private ComboBox<String> currencyToComboBox;

    @FXML
    private Label outputLabel;

    @FXML
    private Button detailsButton;

    @FXML
    private BorderPane exchangePane;

    @FXML
    void viewDetails(ActionEvent event) throws IOException { //view details button to switch scenes
        Parent root = FXMLLoader.load(getClass().getResource("exchangedetails-view.fxml"));

        Stage window = (Stage) detailsButton.getScene().getWindow();
        window.setScene(new Scene(root)); //no size
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outputLabel.setVisible(false); //makes the output label invisible until the user clicks the convert button

        //comboboxFROM choices
        currencyFromComboBox.getItems().add("AUD");
        currencyFromComboBox.getItems().add("CAD");
        currencyFromComboBox.getItems().add("USD");
        currencyFromComboBox.getItems().add("EUR");

        //comboBoxTO choices
        currencyToComboBox.getItems().add("AUD");
        currencyToComboBox.getItems().add("CAD");
        currencyToComboBox.getItems().add("USD");
        currencyToComboBox.getItems().add("EUR");

        //make the button invisible until the user selects a currency
        //detailsButton.setVisible(false);
    }

    /**
     * This method is called when the user clicks on the convert button
     */
    @FXML
    private void convert() throws IOException, InterruptedException { //convert button function
        String textAmount = amountTextField.getText();
        int amount = Integer.parseInt(textAmount);

        //input api params
        APIResponse apiResponse = APIUtility.getConverterFromRapidAPI(amount, currencyFromComboBox.getValue(), currencyToComboBox.getValue());
        CountryCode countryCode = apiResponse.getRates();
        Converter converter = countryCode.getCAD();


        if (apiResponse.resultsReturned()) {
            amountTextField.clear();
            double rate = converter.getRate();
            double newAmount = apiResponse.getAmount();
            double finalAmount = newAmount * rate;
            outputLabel.setText("Converted into: " + finalAmount);
            outputLabel.setVisible(true); //sets output label to visible

        }
        else
        {
            outputLabel.setVisible(false);
            amountTextField.clear();
        }
    }
}
