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

public class ExchangeDetailsController implements Initializable {

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

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        amountLabel.setVisible(false);
        rateLabel.setVisible(false);
        totalLabel.setVisible(false);

        if(amountLabel.getText().isEmpty() || amountLabel.getText().isEmpty() || rateLabel.getText().isEmpty() || totalLabel.getText().isEmpty()){
            amountLabel.setText("Invalid");
            rateLabel.setText("Invalid");
            totalLabel.setText("Invalid");
            amountLabel.setVisible(true);
            rateLabel.setVisible(true);
            totalLabel.setVisible(true);
        }
        //amountLabel.setText(ConverterViewContoller.amount);
        //amountLabel2.setText(ConverterViewContoller.amount);
        //rateLabel.setText(ConverterViewContoller.rate);
        //rateLabel2.setText(ConverterViewContoller.rate);
        //totalLabel.setText(ConverterViewContoller.total);
    }
}


