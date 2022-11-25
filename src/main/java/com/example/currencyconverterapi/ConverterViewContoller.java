package com.example.currencyconverterapi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterViewContoller implements Initializable {

    @FXML
    private Button convertButton;

    @FXML
    private ComboBox<?> currency1ComboBox;

    @FXML
    private ComboBox<?> currency2ComboBox;

    @FXML
    private TextField fromTextField;

    @FXML
    private Label outputLabel;

    @FXML
    private TextField toTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            APIUtility.getConverterFromRapidAPI();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
