/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;

import Controlador.Dao.EmpleadoDao;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Empleado;

/**
 *
 * @author Milton Riofrio
 */
public class EmpleadoServicio{
//    public static String CI_RUC = "ci_ruc";
//    public static String NOMBRE = "nombre";
//    public static String IDENTIFICADOR = "id_persona";
//    public static String TELEFONO = "telefono";
//    public static String DIRECCION = "direccion";
//    public static String CIUDAD = "ciudad";
    public static String IDENTIFICADOR = "id_person";
    public static String ANIOS_TRABAJO = "anios_trabajo";
    public static String LICENCIA = "licencia";
    public static String SUELDO = "sueldo";
    
    private EmpleadoDao obj = new EmpleadoDao();
    
    public Empleado getEmpleado() {
        return obj.getEmpleado();
    }
    public void fijarEmpleado(Empleado empleado) {
        obj.setEmpleado(empleado);
    }
    
    public Boolean guardar() {
        return obj.guardar();
    }
    
    public ListaDoble empleados() {
        return obj.listar();
    }
    
    public ListaDoble empleadosOrdenar(int tipo, String atributo) {
        return obj.ordenar(obj.listar(), tipo, atributo);
    }
    
    public Empleado buscar(String dato, String atributo) {
        ListaDoble empleados = empleadosOrdenar(ListaDoble.ORDENAR_ASCENDENTE, atributo);
        if(empleados.tamano() > 0) {
            return (Empleado)empleados.busquedaBinaria(dato, atributo);
        } else
            return null;
    }
}
