/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.enums;

/**
 *
 * @author Sebastian
 */
public enum Prioridad {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");
    
    private String Prioridad;

    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }

    private Prioridad(String Prioridad){
        this.Prioridad = Prioridad;
    }

    @Override
    public String toString() {
        return Prioridad; //To change body of generated methods, choose Tools | Templates.
    }
}
