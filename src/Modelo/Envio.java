/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ListaDoble.ListaDoble;
import Modelo.enums.Prioridad;

/**
 *
 * @author Sebastian
 */
public class Envio {
    private Long id_envio;
    private double precio;
    private Paquete paquete;
    private ListaDoble hist_entrega = new ListaDoble();
    private Prioridad prioridad;
    private String estado;

    public Long getId_envio() {
        return id_envio;
    }

    public void setId_envio(Long id_envio) {
        this.id_envio = id_envio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public ListaDoble getHist_entrega() {
        return hist_entrega;
    }

    public void setHist_entrega(ListaDoble hist_entrega) {
        this.hist_entrega = hist_entrega;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
