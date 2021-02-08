/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.servicio.EmpleadoServicio;
import Controlador.servicio.RolServicio;
import Modelo.Cuenta;
import Modelo.Empleado;
import Modelo.Rol;

/**
 *
 * @author Milton Riofrio
 */
public class Sesion {
    private static Cuenta cuenta;
    private static Rol rol;
    private static Empleado empleado;

    public static Empleado getEmpleado() {
        return empleado;
    }

    public static void setEmpleado(Empleado empleado) {
        Sesion.empleado = empleado;
    }
    

    public static Cuenta getCuenta() {
        return cuenta;
    }

    public static void setCuenta(Cuenta cuenta) {
        Sesion.cuenta = cuenta;
    }

    public static Rol getRol() {
        return rol;
    }

    public static void setRol(Rol rol) {
        Sesion.rol = rol;
    }
    
    public static void cargarDatos() {        
        System.out.println(cuenta.getId_cuenta().toString());
        empleado = new EmpleadoServicio().buscar(cuenta.getId_cuenta().toString(), EmpleadoServicio.IDENTIFICADOR);
        System.out.println("2 ---> " + RolServicio.IDENTIFICADOR);
        System.out.println("1 ---> " + empleado.getId_rol().toString());
        rol = new RolServicio().buscar(empleado.getId_rol().toString(), RolServicio.IDENTIFICADOR);
    }
}
