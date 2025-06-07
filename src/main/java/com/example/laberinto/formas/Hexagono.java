package com.example.laberinto.formas;

import com.example.laberinto.formas.orientaciones.Orientacion;
import com.example.laberinto.mapa.ElementoMapa;

public class Hexagono extends Forma {

    private ElementoMapa norte;
    private ElementoMapa sur;
    private ElementoMapa noreste;
    private ElementoMapa sureste;
    private ElementoMapa noroeste;
    private ElementoMapa suroest;


    @Override
    public ElementoMapa obtenerElemento(Orientacion orientacion) {
        return null;
    }

    @Override
    public void ponerEn(Orientacion orientacion, ElementoMapa elementoMapa) {

    }
}
