package com.example.laberinto.visitor;

import com.example.laberinto.formas.Forma;
import com.example.laberinto.formas.orientaciones.Este;
import com.example.laberinto.formas.orientaciones.Norte;
import com.example.laberinto.formas.orientaciones.Oeste;
import com.example.laberinto.formas.orientaciones.Sur;
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

    void visitarEste(Este este, Forma forma);

    void visitarNorte(Norte norte, Forma forma);

    void visitarSur(Sur sur, Forma forma);

    void visitarOeste(Oeste oeste, Forma forma);
}
