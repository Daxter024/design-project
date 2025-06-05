package com.example.laberinto.comandos;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.ElementoMapa;

public class Abrir extends Comando {

    public Abrir(ElementoMapa receptor) {
        super(receptor);
    }

    @Override
    public void ejecutar(Ente alguien) {
        if (receptor != null) {
            receptor.abrir(alguien);
        }
    }

    @Override
    public boolean esAbrir() {
        return true;
    }
}
