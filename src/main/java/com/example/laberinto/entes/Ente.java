package com.example.laberinto.entes;

import com.example.laberinto.Juego;
import com.example.laberinto.estados.Estado;
import com.example.laberinto.estados.Vivo;
import com.example.laberinto.formas.orientaciones.Orientacion;
import com.example.laberinto.mapa.ElementoMapa;
import lombok.Data;

@Data
public abstract class Ente {

    protected Estado estado;
    protected Juego juego;
    protected ElementoMapa posicion; // a lo mejor se cambia por point
    protected int poder;
    protected int vidas;

    public Ente() {
        this.vidas = 10;
        this.poder = 1;
        this.estado = new Vivo();
    }

    /**
     * Si muere un Bicho es diferente a un psnj
     */
    public abstract void heMuerto();

    public abstract Ente buscarEnemigo();

    /**
     * Curar, dañar, poder
     **/

    public void agregarVidas(int num) {
        this.vidas += num;
    }

    public void curar(int num) {
        this.agregarVidas(num);
    }

    public void quitarVidas(int num) {
        this.vidas -= num;
        if (this.vidas <= 0) {
            this.heMuerto();
        }
    }

    public void dañar(int num) {
        this.quitarVidas(num);
    }

    public void aumentarPoder(int num) {
        this.poder += num;
    }

    /**
     * Acción
     **/

    public void atacar() {
        Ente ente = buscarEnemigo();
        if (ente != null) {
            ente.esAtacadoPor(this);
        }
    }

    public void esAtacadoPor(Ente atacante) {
        this.estado.enteEsAtacadoPor(this, atacante);
    }

    // Llamado desde Vivo.java
    public void puedeSerAtacado(Ente atacante) {
        // todo: la logica del ataque this -> recibe el ataque de atacante que dependera de su daño
//        System.out.println("Implementar puedeSerAtacado");
        dañar(atacante.getPoder());
        System.out.println(getClass().getSimpleName() + " ha sido atacado por " + atacante.getClass().getSimpleName());
    }

    /**
     * recibirVeneno(...) -> estado.enteRecibeVeneno(...) -> VIVO => ente.PuedeRecibirVeneno()
     **/
    public void recibirVeneno(int num) {
        this.estado.enteRecibeVeneno(this, num);
    }

    /**
     * Se le llama si el estado = Vivo()
     **/
    // LLamado desde Vivo.java
    public void puedeRecibirVeneno(int num) {
        this.vidas -= num;
        if (this.poder > 1) {
            this.poder -= num;
        }
        if (this.poder < 1) {
            this.poder = 1;
        }
        if (this.vidas <= 0) {
            this.heMuerto();
        }
    }

    /**
     * Movimiento
     **/

    public void irA(Orientacion orientacion) {
        orientacion.ir(this);
    }

    // TODO: Comprobar las localizaciones y si se puede ir a ese lugar
    // 1. Personaje -> puede moverse libremente
    // 2. Bicho -> dependerá de su modo
    public void irAlNorte() {
        // this.irA(juego.fabricarEste())
    }

    public void irAlSur() {
    }

    public void irAlEste() {
    }

    public void irAlOeste() {
    }

    // lo considero inutil, si se puede hacer bicho.estado.estaVivo()
    // ademas ya estoy comprobando el estado con la llamada desde estado
    public boolean estaVivo() {
        return this.estado.estaVivo();
    }

}
