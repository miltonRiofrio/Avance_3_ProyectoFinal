/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.HistorialEntrega;

/**
 *
 * @author Milton Riofrio
 */
public class HistorialEntregaDao extends AdaptadorDao{
    private HistorialEntrega historialEntrega;

    public HistorialEntregaDao() {
        super(new Conexion(), HistorialEntrega.class);
    }
    
    public HistorialEntrega getHistorialEntrega() {
        if(historialEntrega == null)
            historialEntrega = new HistorialEntrega();
        return historialEntrega;
    }
    
    public Boolean guardar() {
        try {
            this.getHistorialEntrega().setId_hist_entrega(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getHistorialEntrega());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar historial entrega "+ e);
            return false;
        }
    }
    
    public Boolean eliminar(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }

    public void setHistorialEntrega(HistorialEntrega historialEntrega) {
        this.historialEntrega = historialEntrega;
    }
    
    public ListaDoble ordenar(ListaDoble historialEntrega, int tipo_ordenacion, String atributo) {
        historialEntrega.ordenar(tipo_ordenacion, atributo);
        return historialEntrega;
    }
    
    public ListaDoble ordenar(ListaDoble historialEntrega, int tipo_ordenacion) {
        historialEntrega.ordenar(tipo_ordenacion, "idHEntrega");
        return historialEntrega;
    }
}
