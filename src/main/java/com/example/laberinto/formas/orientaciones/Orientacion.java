package com.example.laberinto.formas.orientaciones;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Forma;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.visitor.Visitor;

import java.awt.*;
import java.util.List;

public abstract class Orientacion {

    public abstract Point calcularPosicionDesde(Forma forma);

    public abstract List<Comando> obtenerComandos(Forma forma);

    public abstract ElementoMapa obtenerElementoEn(Contenedor contenedor);

    public abstract void ponerElementoEn(ElementoMapa elementoMapa, Contenedor contenedor);

    public abstract void ir(Ente alguien);

    public abstract void aceptar(Visitor visitor, Forma forma);

//    public abstract void recorrer();
}
