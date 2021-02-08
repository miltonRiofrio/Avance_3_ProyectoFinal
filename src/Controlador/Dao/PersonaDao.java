/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Controlador.servicio.RolServicio;
import Modelo.Persona;
import Modelo.Rol;


/**
 *
 * @author Milton Riofrio
 */
public class PersonaDao extends AdaptadorDao {
    private Persona persona;
    private RolDao rdao = new RolDao();
    
    public PersonaDao() {
        super(new Conexion(), Persona.class);
    }

    public Persona getPersona() {
        if(persona == null)
            persona = new Persona();
        return persona;
    }
    
    public Boolean guardarPersona (Persona persona) {
        try {
            persona.setId_persona(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            Rol rol = new RolServicio().buscar("3", RolServicio.IDENTIFICADOR);
            persona.setId_rol(rol.getId_rol());
            this.guardar(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar persona "+ e);
            return false;
        }
    }
    
    public Boolean eliminarPersona(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public ListaDoble ordenar(ListaDoble estudiantes, int tipo_ordenacion, String atributo) {
        estudiantes.ordenar(tipo_ordenacion, atributo);
        return estudiantes;
    }
    
    /*public Persona obtenerId(Long id) {
        ListaSimple personas = ordenar(listar(), ListaSimple.ORDENAR_ASCENDENTE, "id");
        return (Persona)personas.busquedaBinaria(id.toString(), "id");
    }*/
}
