package com.example.laberinto;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Personaje;
import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Habitacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Bicho alguien = new Bicho();
        Juego juego = new Juego();
        Personaje personaje = new Personaje();
        Puerta p = new Puerta();

        Habitacion habitacion = juego.fabricarHabitacion(1);
        p.setLado1(habitacion);
        habitacion.agregarHijo(p);

        Habitacion habitacion2 = juego.fabricarHabitacion(2);

        personaje.setPosicion(habitacion);

        Pared pa = new Pared();
        p.abrir(personaje);
        personaje.setPosicion(habitacion2);
        p.abrir(personaje);

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