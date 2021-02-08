/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;

import Controlador.Dao.ArticuloDao;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Articulo;

/**
 *
 * @author Milton Riofrio
 */
public class ArticuloServicio {
    public static String IDARTICULOS = "id_articulo";
    public static String NOMBREARTICULO = "nombre_articulo";
    public static String CANTIDAD = "cantidad";
    public static String CATEGORIA = "categoria";
    public static String PAQUETE = "paquete";
    
    private ArticuloDao obj = new ArticuloDao();
    
    public Articulo getArticulo() {
        return obj.getArticulo();
    }
    public void fijarArticulo(Articulo articulo) {
        obj.setArticulo(articulo);
    }
    
    public Boolean guardar() {
        return obj.guardar();
    }
    
    public ListaDoble articulos() {
        return obj.listar();
    }
    
    public ListaDoble articuloOrdenar(int tipo, String atributo) {
        return obj.ordenar(obj.listar(), tipo, atributo);
    }
    
    public Articulo buscar(String dato, String atributo) {
        ListaDoble articulos = articuloOrdenar(ListaDoble.ORDENAR_ASCENDENTE, atributo);
        if(articulos.tamano() > 0) {
            return (Articulo)articulos.busquedaBinaria(dato, atributo);
        } else
            return null;
    }
}
