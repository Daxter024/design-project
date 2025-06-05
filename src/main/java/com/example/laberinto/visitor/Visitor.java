package com.example.laberinto.visitor;

import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;

public interface Visitor {
    void visitarPuerta(Puerta puerta);

    void visitarPared(Pared pared);
}
