package com.example.laberinto.tipos;

import com.example.laberinto.entes.Ente;

public class Venenoso extends Tipo {
    @Override
    public void accionar(Ente alguien) {
//        alguien.puedeRecibirVeneno(5);
        alguien.getEstado().enteRecibeVeneno(alguien, 5);
    }

    @Override
    public boolean esVenenosa() {
        return true;
    }
}
