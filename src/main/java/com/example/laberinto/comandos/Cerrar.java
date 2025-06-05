package com.example.laberinto.comandos;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.ElementoMapa;

public class Cerrar extends Comando {

    public Cerrar(ElementoMapa receptor) {
        super(receptor);
    }

    @Override
    public void ejecutar(Ente alguien) {
        if (receptor != null) {
            receptor.cerrar(alguien);
        }
    }

    @Override
    public boolean esCerrar() {
        return true;
    }
}
