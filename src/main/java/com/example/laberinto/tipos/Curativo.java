package com.example.laberinto.tipos;

import com.example.laberinto.entes.Ente;

public class Curativo extends Tipo {
    @Override
    public void accionar(Ente alguien) {
        alguien.curar(10);
    }

    @Override
    public boolean esCurativa() {
        return true;
    }
}
