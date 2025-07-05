package com.example.laberinto.entes;

import com.example.laberinto.estados.Muerto;
import com.example.laberinto.formas.orientaciones.Orientacion;
import com.example.laberinto.modos.Modo;
import lombok.Data;

import java.util.List;

@Data
public class Bicho extends Ente {

    protected Modo modo;

    public Bicho() {
        super();
    }

    // Deberia estar en bucle, es el algoritmo de template
    // bicho.actua() -> estado.actua(unBicho) -> unBicho.puedeActuar() -> this.modo.actua(this) -> atacar,dormir,caminar
    public void actua() {
        this.estado.actua(this);
    }

    public void puedeActuar() {
        if (this.modo != null) {
            this.modo.actua(this);
        }
    }

    @Override
    public void heMuerto() {
        this.estado = new Muerto();
        if (this.juego != null) {
//            todo: this.juego.muereBicho(this); -> Si mueren todos se gana el juego
        }
    }

    @Override
    public Ente buscarEnemigo() {
        if (this.juego != null) {
            return juego.buscarPersonaje(this);
        }
        return null;
    }

    // TODO

    public void atacarATodos() {
    }

    public List<Bicho> buscarBichos() {
        return null;
    }

    public Orientacion obtenerOrientacionAleatoria() {
        return null;
    }

}
