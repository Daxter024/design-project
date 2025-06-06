package com.example.laberinto.visitor;

import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Armario;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.mapa.contenedores.Laberinto;
import com.example.laberinto.mapa.hojas.Tunel;
import com.example.laberinto.mapa.hojas.decoradores.Bomba;

public interface Visitor {
    void visitarPuerta(Puerta puerta);

    void visitarPared(Pared pared);

    void visitarHabitacion(Habitacion habitacion);

    void visitarArmario(Armario armario);

    void visitarLaberinto(Laberinto laberinto);

    void visitarBomba(Bomba bomba);

    void visitarTunel(Tunel tunel);
}
