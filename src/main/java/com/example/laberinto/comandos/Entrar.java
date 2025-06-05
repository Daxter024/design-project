package com.example.laberinto.comandos;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.ElementoMapa;

public class Entrar extends Comando {

    public Entrar(ElementoMapa receptor) {
        super(receptor);
    }

    @Override
    public void ejecutar(Ente alguien) {
        if (receptor != null) {
            /**
             * Se supone que todos los elementos del mapa tienen la función abrir aunque no haga nada funcional
             */
            receptor.entrar(alguien);
        }
    }

    @Override
    public boolean esEntrar() {
        return true;
    }
}
