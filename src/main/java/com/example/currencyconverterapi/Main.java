package com.example.currencyconverterapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("converter-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //set icon
        stage.getIcons().add(new Image("file:src/main/resources/img/money.png"));

        stage.setTitle("Currency Converter!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}