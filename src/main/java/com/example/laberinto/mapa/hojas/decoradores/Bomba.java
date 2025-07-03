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
        this.puntosVida = 5;
    }

    public void activar() {
        this.activa = true;
        System.out.println("Bomba activada");
    }

    public void desactivar() {
        this.activa = false;
        System.out.println("Bomba desactivada");
    }


    @Override
    public void abrir(Ente alguien) {

    }

    @Override
    public void cerrar(Ente alguien) {

    }

    @Override
    public void entrar(Ente alguien) {
        if (activa) {
            System.out.println("¡" + alguien.getClass().getSimpleName() + " ha activado la bomba!");
            alguien.dañar(this.puntosVida);
            desactivar();
        } else if (componente != null) {
            componente.entrar(alguien);
        }
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
