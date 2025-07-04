package com.example.laberinto.mapa.contenedores;

import com.example.laberinto.comandos.Entrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Cuadrado;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Laberinto extends Contenedor {

    public Laberinto() {
        this.forma = new Cuadrado();
        agregarComando(new Entrar(this));
    }

    @Override
    public void abrir(Ente alguien) {
        System.out.println("Operación no permitida");
    }

    @Override
    public void cerrar(Ente alguien) {
        System.out.println("Operacion no permitida");
    }

    public void entrar(Ente alguien) {
        System.out.println(alguien.getClass().getSimpleName() + " entrando al laberinto");
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarLaberinto(this);
    }

    public void recorrer(java.util.function.Consumer<ElementoMapa> bloque) {
        System.out.println("Recorriendo laberinto.");
        bloque.accept(this);
        for (ElementoMapa hijo : hijos) {
            hijo.recorrer(bloque);
        }
    }

    @Override
    public boolean esLaberinto() {
        return true;
    }
}
