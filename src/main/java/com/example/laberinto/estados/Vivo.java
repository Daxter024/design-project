package com.example.laberinto.estados;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Ente;

public class Vivo extends Estado {
    @Override
    public void actua(Bicho unBicho) {
        // todo
    }

    @Override
    public void enteEsAtacadoPor(Ente atacado, Ente atacante) {
        // todo
    }

    @Override
    public void enteRecibeVeneno(Ente ente, int num) {
        // todo
    }

    @Override
    public boolean estaVivo() {
        return true;
    }
}
