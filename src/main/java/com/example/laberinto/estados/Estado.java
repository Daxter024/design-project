package com.example.laberinto.estados;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Ente;
import lombok.Data;

@Data
public abstract class Estado {

    public abstract void actua(Bicho unBicho);

    public abstract void enteEsAtacadoPor(Ente atacado, Ente atacante);

    public abstract void enteRecibeVeneno(Ente ente, int num);

    public abstract boolean estaVivo();
}
