/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Cuenta;

/**
 *
 * @author Sebastian
 */
public class CuentaDao extends AdaptadorDao{
    
    private Cuenta cuenta;
    
    public CuentaDao() {
        super(new Conexion(), Cuenta.class);
    }

    public Cuenta getCuenta() {
        if(cuenta == null)
            cuenta = new Cuenta();
        return cuenta;
    }
    
    public Boolean guardar() {
        try {
            this.getCuenta().setId_cuenta(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar estudiante "+ e);
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

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public ListaDoble ordenar(ListaDoble estudiantes, int tipo_ordenacion, String parametro) {
        estudiantes.ordenar(tipo_ordenacion, parametro);
        return estudiantes;
    }
    
    public Cuenta inicioSesion(String usuario, String clave) {
        ListaDoble cuentas = listar();
        cuentas = ordenar(cuentas, ListaDoble.ORDENAR_ASCENDENTE, "usuario");
        Cuenta cuenta = (Cuenta) cuentas.busquedaBinaria(usuario, "usuario");//select * from cuenta where usuario = "xxxxx" //inyeccion sql select usuario form cueta where 1 = 1;
        if(cuenta != null) {
            if(!cuenta.getContrasenia().equals(clave)) 
                cuenta = null;            
        }
        return cuenta;
    }    
    
}
