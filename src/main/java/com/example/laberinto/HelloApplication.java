package com.example.laberinto;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Bicho alguien = new Bicho();
        Puerta p = new Puerta();
        Pared pa = new Pared();
        p.abrir(alguien);
        pa.abrir(alguien);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}