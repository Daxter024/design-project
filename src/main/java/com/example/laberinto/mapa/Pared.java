package com.example.laberinto.mapa;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Pared extends ElementoMapa {

    public Pared() {

    }

    @Override
    public void entrar(Ente alguien) {
        System.out.println(alguien.getClass().getSimpleName() + " se ha chocado con una pared");
    }

    @Override
    public void abrir(Ente alguien) {
        System.out.println("Una pared no puede abrirse");
    }

    @Override
    public void cerrar(Ente alguien) {
        System.out.println("Una pared no puede cerrarse");
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarPared(this);
    }

    @Override
    public boolean esPared() {
        return true;
    }
}
