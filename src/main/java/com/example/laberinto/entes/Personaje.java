package com.example.laberinto.entes;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.estados.Muerto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Personaje extends Ente {

    protected String nick;

    public Personaje() {
        super();
    }

    @Override
    public void heMuerto() {
        this.estado = new Muerto();
        if (this.juego != null) {
            this.juego.personajeMuere();
        }
    }

    @Override
    public Ente buscarEnemigo() {
        // todo: hace falta comprobar si el estado es Vivo? o el hilo va acabar definitivamente
        if (this.juego != null) {
            return this.juego.buscarBicho();
        }
        return null;
    }

    public List<Comando> obtenerComandos() {
        if (this.posicion != null) {
            return this.posicion.getComandos();
        }
        return new ArrayList<Comando>();
    }

}
