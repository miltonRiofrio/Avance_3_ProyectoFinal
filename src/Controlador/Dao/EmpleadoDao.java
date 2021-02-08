/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Empleado;

/**
 *
 * @author Sebastian
 */
public class EmpleadoDao extends AdaptadorDao {

    private Empleado empleado;

    public EmpleadoDao() {
        super(new Conexion(), Empleado.class);
    }

    public Empleado getEmpleado() {
        if (empleado == null) {
            empleado = new Empleado();
        }
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean guardar() {
        try {
            this.getEmpleado().setId_persona(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.getEmpleado().setId_person(this.getEmpleado().getId_persona());
            System.out.println("NOMBRE EMPLEADOOO: " + this.getEmpleado().getNombre());
            this.guardar(this.getEmpleado());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar empleado " + e);
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

    public ListaDoble ordenar(ListaDoble empleados, int tipo_ordenacion, String atributo) {
        empleados.ordenar(tipo_ordenacion, atributo);
        return empleados;
    }

}
