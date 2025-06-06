package com.example.laberinto.mapa.hojas.decoradores;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.hojas.Decorator;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Bomba extends Decorator {

    private boolean activa;
    private int puntosVida;

    public Bomba() {
        this.activa = false;
    }

    @Override
    public void abrir(Ente alguien) {

    }

    @Override
    public void cerrar(Ente alguien) {

    }

    @Override
    public void entrar(Ente alguien) {

    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarBomba(this);
    }

    @Override
    public boolean esBomba() {
        return true;
    }
}
