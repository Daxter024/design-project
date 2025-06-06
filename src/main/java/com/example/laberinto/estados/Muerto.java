package com.example.laberinto.estados;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Ente;

public class Muerto extends Estado {
    @Override
    public void actua(Bicho unBicho) {
        System.out.println("Bicho está muerto no puede actuar");
    }

    @Override
    public void enteEsAtacadoPor(Ente atacado, Ente atacante) {
        System.out.println(atacado.getClass().getSimpleName() + " ya está muerto y no puede ser atacado.");
    }

    @Override
    public void enteRecibeVeneno(Ente ente, int num) {
        System.out.println(ente.getClass().getSimpleName() + " está muerto y no puede recibir veneno.");
    }

    @Override
    public boolean estaVivo() {
        return false;
    }
}
