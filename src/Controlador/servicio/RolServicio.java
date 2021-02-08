/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;

import Controlador.Dao.RolDao;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Rol;

/**
 *
 * @author Milton Riofrio
 */
public class RolServicio {
    
    public static String IDENTIFICADOR = "id_rol";
    public static String ROL = "rol";
    
    private RolDao obj = new RolDao();
    
    public Rol getRol() {
        return obj.getRol();
    }
    public void crearRoles() {
        obj.crearRoles();
    }
    
    public ListaDoble rolesOrdenar(int tipo, String atributo) {
        return obj.ordenar(obj.listar(), tipo, atributo);
    }
    
    public Rol buscar(String dato, String atributo) {
        ListaDoble roles = rolesOrdenar(ListaDoble.ORDENAR_ASCENDENTE, atributo);
        
        if(roles.tamano() > 0) {
            return (Rol)roles.busquedaBinaria(dato, atributo);
        } else
            return null;
    }
    
}
