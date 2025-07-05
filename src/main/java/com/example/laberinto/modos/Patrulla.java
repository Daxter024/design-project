package com.example.laberinto.modos;

import com.example.laberinto.entes.Bicho;
import lombok.Data;

@Data
public class Patrulla extends Modo {

    public Patrulla() {
        this.color = "amarillo";
    }

    @Override
    void atacar(Bicho bicho) {
        bicho.atacar();
    }

    @Override
    void caminar(Bicho bicho) {
        bicho.caminar();
    }

    @Override
    void dormir() {
//        System.out.println("Bicho patrulla no duerme");
    }
}
