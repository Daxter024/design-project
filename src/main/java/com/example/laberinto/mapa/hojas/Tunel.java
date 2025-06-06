package com.example.laberinto.mapa.hojas;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.Hoja;
import com.example.laberinto.visitor.Visitor;

public class Tunel extends Hoja {

    public Tunel() {

    }

    @Override
    public void abrir(Ente alguien) {

    }

    @Override
    public void cerrar(Ente alguien) {

    }

    @Override
    public void entrar(Ente alguien) {
        System.out.println("Entrando en el tunel");
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarTunel(this);
    }

    @Override
    public boolean esTunel() {
        return true;
    }
}
