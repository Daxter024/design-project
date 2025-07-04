package com.example.laberinto.model;

import lombok.Data;

import java.util.List;

@Data
public class HijoJson {
    public String tipo;
    public Integer num;
    public List<HijoJson> hijos;
}
