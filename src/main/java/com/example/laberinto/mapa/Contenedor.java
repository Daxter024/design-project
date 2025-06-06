package com.example.laberinto.mapa;

import com.example.laberinto.formas.Forma;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Contenedor extends ElementoMapa {

    protected Forma forma;
    protected List<ElementoMapa> hijos = new ArrayList<ElementoMapa>();
    protected int num;

}
