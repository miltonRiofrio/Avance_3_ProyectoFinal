/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Articulo;

/**
 *
 * @author Milton Riofrio
 */
public class ArticuloDao extends AdaptadorDao{
    private Articulo articulo;
    private ListaDoble ld = new ListaDoble();

    public ArticuloDao() {
        super(new Conexion(), Articulo.class);
    }
    
    public Articulo getArticulo() {
        if(articulo == null)
            articulo = new Articulo();
        return articulo;
    }
    
    public Boolean guardar() {
        try {
            this.getArticulo().setId_articulo(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getArticulo());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar el articulo "+ e);
            return false;
        }
    }
    
    public Boolean eliminarArt(int pos) {
        try {
            System.out.println("anteeeeeeessss");
            this.eliminar(pos);
            System.out.println("despuesssssssssss");
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    public ListaDoble ordenar(ListaDoble articulo, int tipo_ordenacion, String atributo) {
        articulo.ordenar(tipo_ordenacion, atributo);
        return articulo;
    }
    
    public ListaDoble ordenar(ListaDoble articulo, int tipo_ordenacion) {
        articulo.ordenar(tipo_ordenacion, "idArticulo");
        return articulo;
    }
    
    private Articulo clonarArticulo() {
        Articulo aux = new Articulo();
        aux.setCantidad(articulo.getCantidad());
        aux.setCategoria(articulo.getCategoria());
        aux.setId_articulo(articulo.getId_articulo());
        aux.setNombre_articulo(articulo.getNombre_articulo());
        aux.setPaquete(articulo.getPaquete());
        return aux;
    }
    
    public ListaDoble guardarArticulo() {
        try {
            ld.insertar(clonarArticulo());
            setArticulo(null);
            return ld;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta " + e);
            return null;
        }
    }
}
