package com.example.laberinto.mapa;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoMapa {

    protected List<Comando> comandos = new ArrayList<Comando>();
    protected Contenedor padre;


    public void agregarComando(Comando comando) {
        this.comandos.add(comando);
    }

    public void quitarComando(Comando comando) {
        this.comandos.remove(comando);
    }


    /**
     * Methods for doors
     **/

    // puede ser que en lugar de hacerlos abstractos es mejor tener una implementacion y luego override
    public abstract void abrir(Ente alguien);

    public abstract void cerrar(Ente alguien);

    public void entrar(Ente alguien) {
        System.out.println(alguien.getClass().getSimpleName() + " está entrando en un elemento mapa genérico.");
    }

    /**
     * Method podría ser abstract para que todas las subclases lo implementasen, pero en este caso solo Puerta lo sobrescribe
     */

    // De momento es inútil
    public void entrar() {
        System.out.println("Un elemento generico está siendo entrado");
    }

    /**
     * Visitor
     **/

    public abstract void aceptar(Visitor visitor);

    /**
     * Testing
     **/

    public boolean esArmario() {
        return false;
    }

    public boolean esBomba() {
        return false;
    }

    public boolean esHabitacion() {
        return false;
    }

    public boolean esPared() {
        return false;
    }

    public boolean esPuerta() {
        return false;
    }

    public boolean esTunel() {
        return false;
    }

    public boolean esLaberinto() {
        return false;
    }
}
