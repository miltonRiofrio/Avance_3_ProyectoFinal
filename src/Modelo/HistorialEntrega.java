/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class HistorialEntrega {
    private Long id_hist_entrega;
    private Envio envio;
    private Empleado camionero;
    private Camion camion;
    private Date fecha_entrega;
    private String ciudad_origen;
    private String ciudad_destino;

    public Long getId_hist_entrega() {
        return id_hist_entrega;
    }

    public void setId_hist_entrega(Long id_hist_entrega) {
        this.id_hist_entrega = id_hist_entrega;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Empleado getCamionero() {
        return camionero;
    }

    public void setCamionero(Empleado camionero) {
        this.camionero = camionero;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    public String getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }  
}
