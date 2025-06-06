package com.example.laberinto.visitor;

import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Habitacion;

public interface Visitor {
    void visitarPuerta(Puerta puerta);

    void visitarPared(Pared pared);

    void visitarHabitacion(Habitacion habitacion);
}
