/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ListaDoble.ListaDoble;
import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class Paquete {
    private Long id_paquete;
    private Persona destinatario;
    private Persona remitente;
    private double peso;
    private boolean fragil;
    private Date fecha_envio;
    private Date fecha_entrega;
    private ListaDoble contenido = new ListaDoble();

    public Long getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(Long id_paquete) {
        this.id_paquete = id_paquete;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean getFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public ListaDoble getContenido() {
        return contenido;
    }

    public void setContenido(ListaDoble contenido) {
        this.contenido = contenido;
    }
}
