package com.example.laberinto.formas;

import com.example.laberinto.formas.orientaciones.*;
import com.example.laberinto.mapa.ElementoMapa;
import lombok.Data;

@Data
public class Cuadrado extends Forma {

    private ElementoMapa este;
    private ElementoMapa oeste;
    private ElementoMapa norte;
    private ElementoMapa sur;

    @Override
    public ElementoMapa obtenerElemento(Orientacion orientacion) {
        if (orientacion instanceof Este) return este;
        if (orientacion instanceof Oeste) return oeste;
        if (orientacion instanceof Sur) return sur;
        if (orientacion instanceof Norte) return norte;
        return null;
    }

    @Override
    public void ponerEn(Orientacion orientacion, ElementoMapa elementoMapa) {
        if (orientacion instanceof Este) este = elementoMapa;
        if (orientacion instanceof Oeste) oeste = elementoMapa;
        if (orientacion instanceof Sur) sur = elementoMapa;
        if (orientacion instanceof Norte) norte = elementoMapa;
    }
}
