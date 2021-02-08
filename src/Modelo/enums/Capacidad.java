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
public enum Capacidad {
    lIVIANA("Liviana"),
    MEDIA("Media"),
    PESADA("Pesada");
    
    private String Capacidad;

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String Capacidad) {
        this.Capacidad = Capacidad;
    }
    
    private Capacidad (String Capacidad){
        this.Capacidad = Capacidad;
    }

    @Override
    public String toString() {
        return Capacidad; //To change body of generated methods, choose Tools | Templates.
    }
  
}
