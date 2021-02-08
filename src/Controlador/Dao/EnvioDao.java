/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Envio;

/**
 *
 * @author Milton Riofrio
 */
public class EnvioDao extends AdaptadorDao{
    private Envio envio;
    private ListaDoble ld = new ListaDoble();
    private PersonaDao pdao = new PersonaDao();
    
    public ListaDoble getLd() {
        return ld;
    }

    public void setLd(ListaDoble ld) {
        this.ld = ld;
    }
    
    public EnvioDao() {
        super(new Conexion(), Envio.class);
    }
    
    public Envio getEnvio() {
        if(envio == null)
            envio = new Envio();
        return envio;
    }
    
    //*******************************************
    
    public Boolean guardar() {
        try {
            this.getEnvio().setId_envio(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.getEnvio().getPaquete().setId_paquete(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            pdao.guardarPersona(this.getEnvio().getPaquete().getDestinatario());
            pdao.guardarPersona(this.getEnvio().getPaquete().getRemitente());
            //this.getEnvio().getPaquete().getRemitente().setId_rol(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getEnvio());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar envio "+ e);
            return false;
        }
    }
    
    public Boolean eliminarEnvio(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    
    public ListaDoble ordenar(ListaDoble envios, int tipo_ordenacion, String atributo) {
        envios.ordenar(tipo_ordenacion, atributo);
        return envios;
    }
    
    public ListaDoble ordenar(ListaDoble envios, int tipo_ordenacion) {
        envios.ordenar(tipo_ordenacion, "idEnvio");
        return envios;
    }
    
    //*************************************************
    public Envio clonarEnvio() {
        Envio aux = new Envio();
        aux.setEstado(envio.getEstado());
        aux.setPaquete(envio.getPaquete());
        aux.setHist_entrega(envio.getHist_entrega());
        aux.setId_envio(envio.getId_envio());
        aux.setPrecio(envio.getPrecio());
        aux.setPrioridad(envio.getPrioridad());
        return aux;
    }
    
    public Boolean guardarEnvioLD() {
        try {
            ld.insertar(clonarEnvio());
            setEnvio(null);
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta " + e);
            return false;
        }
    }
}
