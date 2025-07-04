package com.example.laberinto.formas.orientaciones;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Forma;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public class Oeste extends Orientacion {
    @Override
    public Point calcularPosicionDesde(Forma forma) {
        if (forma.getPunto() != null) {
            return new Point(forma.getPunto().x - 1, forma.getPunto().y);
        }
        return null;
    }

    @Override
    public List<Comando> obtenerComandos(Forma forma) {
        return List.of();
    }

    @Override
    public ElementoMapa obtenerElementoEn(Contenedor contenedor) {
        return null;
    }

    @Override
    public void ponerElementoEn(ElementoMapa elementoMapa, Contenedor contenedor) {

    }

    @Override
    public void ir(Ente alguien) {

    }

    @Override
    public void aceptar(Visitor visitor, Forma forma) {
        visitor.visitarOeste(this, forma);
    }
}
