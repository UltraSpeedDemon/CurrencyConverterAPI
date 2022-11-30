package com.example.currencyconverterapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ExchangeDetailsController implements Initializable {

    @FXML
    private Button returnButton;

    @FXML
    void viewConverter(ActionEvent event) throws IOException { //view converter button to switch scenes
        Parent root = FXMLLoader.load(getClass().getResource("converter-view.fxml"));

        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root)); //no size
    }

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

    }
}


