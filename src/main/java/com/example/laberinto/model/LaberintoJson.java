package com.example.laberinto.model;

import lombok.Data;

import java.util.List;

@Data
public class LaberintoJson {
    public LaberintoJson() {
    } // requerido para Jackson

    public String forma;
    public List<ElementoMapaJson> laberinto;
    public List<List<Object>> puertas;
    public List<BichoJson> bichos;
}

