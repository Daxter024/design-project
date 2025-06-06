package com.example.laberinto.mapa.contenedores;

import com.example.laberinto.comandos.Abrir;
import com.example.laberinto.comandos.Cerrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Cuadrado;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.visitor.Visitor;

public class Armario extends Contenedor {

    public Armario(int num) {
        this.num = num;
        this.forma = new Cuadrado();
        agregarComando(new Abrir(this));
        agregarComando(new Cerrar(this));
    }

    @Override
    public void abrir(Ente alguien) {
        // todo
    }

    @Override
    public void cerrar(Ente alguien) {
        // todo
    }

    @Override
    public void entrar(Ente alguien) {
        System.out.println("No se puede entrar en un armario.");
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarArmario(this);
    }

    @Override
    public boolean esArmario() {
        return true;
    }
}
