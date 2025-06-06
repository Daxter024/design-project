package com.example.laberinto.mapa.contenedores;

import com.example.laberinto.comandos.Entrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Cuadrado;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.visitor.Visitor;

public class Habitacion extends Contenedor {

    public Habitacion(int num) {
        this.num = num;
        this.forma = new Cuadrado();
        agregarComando(new Entrar(this));
    }


    @Override
    public void abrir(Ente alguien) {
        System.out.println("Una habitación no puede ser abierta");
    }

    @Override
    public void cerrar(Ente alguien) {
        System.out.println("No puedes cerrar una habitación.");
    }

    public void entrar(Ente alguien) {
        System.out.println(alguien.getClass().getSimpleName() + " está entrando en una habitación.");
        // todo: settear su posicion
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarHabitacion(this);
        // todo: aceptar a los hijos y forma
    }

    @Override
    public boolean esHabitacion() {
        return true;
    }
}
