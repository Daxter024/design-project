package com.example.laberinto.estados;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Ente;

public class Vivo extends Estado {
    @Override
    public void actua(Bicho unBicho) {
        unBicho.puedeActuar();
    }

    @Override
    public void enteEsAtacadoPor(Ente atacado, Ente atacante) {
        atacado.puedeSerAtacado(atacante);
    }

    @Override
    public void enteRecibeVeneno(Ente ente, int num) {
        ente.puedeRecibirVeneno(num);
    }

    @Override
    public boolean estaVivo() {
        return true;
    }
}
