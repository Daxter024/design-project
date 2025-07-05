package com.example.laberinto;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.formas.orientaciones.*;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Armario;
import com.example.laberinto.mapa.contenedores.Habitacion;

public class LaberintoFactory {

    public Juego juego = new Juego();

    public Habitacion fabricarHabitacion(String tipo, int num) {

        switch (tipo) {
            case "normal":
                return juego.fabricarHabitacion(num);

            default:
                return new Habitacion(num);
        }
    }

    public ElementoMapa fabricarElementoMapa(String elementoMapa, String tipo, Integer num) {
        switch (elementoMapa) {
            case "habitacion":
                switch (tipo) {
                    case "normal":
                        return new Habitacion(num);
                    default:
                        return new Habitacion(num);
                }
            case "armario":
                switch (tipo) {
                    case "normal":
                        return new Armario(num);
                    default:
                        return new Armario(num);
                }
            case "cofre":
                switch (tipo) {
                    case "normal":
                        return juego.fabricarCofre(num);
                    case "curativo":
                        return juego.fabricarCofreCurativo(num);
                    case "venenoso":
                        return juego.fabricarCofreVenenoso(num);
                }

            default:
                return null;
        }
    }

    public Puerta fabricarPuerta(Habitacion hab1, String dirDesde, Habitacion hab2, String dirHasta) {
        Puerta p = new Puerta();
        p.setLado1(hab1);
        p.setLado2(hab2);
        return p;
    }

    public Bicho fabricarBicho(String modo, Habitacion habitacion) {
        switch (modo) {
            case "normal":
                return juego.fabricarBicho(habitacion);
            case "perezoso":
                return juego.fabricarBichoPerezoso(habitacion);
            case "agresivo":
                return juego.fabricarBichoAgresivo(habitacion);
            case "patrulla":
                return juego.fabricarBichoPatrulla(habitacion);
            case "canibal":
                return juego.fabricarBichoCanibal(habitacion);
            default:
                return juego.fabricarBicho();
        }
    }

    public Orientacion fabricarOrientacion(String orientacion) {
        switch (orientacion) {
            case "Norte":
                return new Norte();
            case "Sur":
                return new Sur();
            case "Este":
                return new Este();
            case "Oeste":
                return new Oeste();
            default:
                return null;
        }
    }
}
