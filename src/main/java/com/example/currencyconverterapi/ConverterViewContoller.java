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
    private ComboBox<Converter> currencyFromComboBox;

    @FXML
    private ComboBox<Converter> currencyToComboBox;

    @FXML
    private Label outputLabel;

    @FXML
    private Button detailsButton;

    @FXML
    void viewDetails(ActionEvent event) throws IOException { //view details button to switch scenes
        Parent root = FXMLLoader.load(getClass().getResource("exchangedetails-view.fxml"));

        Stage window = (Stage) detailsButton.getScene().getWindow();
        window.setScene(new Scene(root)); //no size
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outputLabel.setVisible(false); //makes the output label invisible until the user clicks the convert button

        try{
            APIUtility.getConverterFromRapidAPI();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called when the user clicks on the convert button
     */
    @FXML
    private void convert() throws IOException, InterruptedException { //convert button function
        String finalAmount = amountTextField.getText();
        int amount = Integer.parseInt(finalAmount);

        //input api params
        APIResponse apiResponse = APIUtility.getConverterFromRapidAPI(amount, currencyFromComboBox.getValue().toString(), currencyToComboBox.getValue().toString());
        if (apiResponse.resultsReturned())
        {
            amountTextField.clear();
            outputLabel.setVisible(true); //sets output label to visible
            Collections.sort(movies, new Comparator<Movie>() {
                @Override
                public int compare(Movie m1, Movie m2) {
                    if (m2.getYear().compareTo(m1.getYear())==0)
                        return (m1.getTitle().compareTo(m2.getTitle()));
                    else
                        return m2.getYear().compareTo(m1.getYear());
                }
            });
            listView.getItems().addAll(movies);
        }
        else
        {
            outputLabel.setVisible(false);
            amountTextField.clear();
        }
    }
}
