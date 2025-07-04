package com.example.laberinto.model;

import lombok.Data;

import java.util.List;

@Data
public class ElementoMapaJson {
    public String elementoMapa;
    public String tipo;
    public int num;
    public List<ElementoMapaJson> hijos;
}
