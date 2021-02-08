/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.ListaDoble.ListaDoble;


/**
 *
 * @author Sebastian
 */
public interface InterfazDao {
    public void guardar(Object o) throws Exception;
    public Boolean modificar(Object o);
    public ListaDoble listar();
    public void eliminar(Object pos) throws Exception;
}
