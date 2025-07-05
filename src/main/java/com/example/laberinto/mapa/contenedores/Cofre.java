package com.example.laberinto.mapa.contenedores;

import com.example.laberinto.comandos.Abrir;
import com.example.laberinto.comandos.Cerrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Cuadrado;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.tipos.Tipo;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Cofre extends Contenedor {

    private Tipo tipo;

    public Cofre(int num) {
        this.num = num;
        this.forma = new Cuadrado();
        agregarComando(new Abrir(this));
        agregarComando(new Cerrar(this));
    }

    @Override
    public void abrir(Ente alguien) {
        this.tipo.accionar(alguien);
    }

    @Override
    public void cerrar(Ente alguien) {

    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarCofre(this);
    }

    @Override
    public boolean esCofre() {
        return true;
    }
}
