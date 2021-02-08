/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import java.util.UUID;
import Modelo.Rol;

/**
 *
 * @author Sebastian
 */
public class RolDao extends AdaptadorDao {

    private Rol rol;

    public RolDao() {
        super(new Conexion(), Rol.class);
    }

    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }

    public Boolean guardar() {
        try {
            this.getRol().setId_rol(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            //System.out.println("aaaaa: " + Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol " + e);
            return false;
        }
    }
    
    public Boolean eliminarRol(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public ListaDoble ordenar(ListaDoble empleado, int tipo_ordenacion, String atributo) {
        empleado.ordenar(tipo_ordenacion, atributo);
        return empleado;
    }

    public void crearRoles() {
        EmpleadoDao edao = new EmpleadoDao();
        if (listar().tamano() == 0) {
            Rol admin = new Rol();
            admin.setRol("Administrador");
            setRol(admin);
            guardar();
            setRol(null);
            Rol secret = new Rol();
            secret.setRol("Secretario");
            setRol(secret);
            guardar();
            setRol(null);
            Rol cliente = new Rol();
            cliente.setRol("Cliente");
            setRol(cliente);
            guardar();
            setRol(null);
            if (edao.listar().tamano() == 0) {
                ListaDoble listado = listar().ordenar(ListaDoble.ORDENAR_ASCENDENTE, "rol");
                Object objeto = listado.busquedaBinaria("Administrador", "rol");
                long id_rol = (objeto != null) ? ((Rol)objeto).getId_rol() : -1;
                System.out.println("Se encontro " + objeto);
                System.out.println("listado:");
                listado.verDato();
                System.out.println("********");
                
                edao.getEmpleado().setNombre("Administrador");
                edao.getEmpleado().setCi_ruc("1150069324");
                edao.getEmpleado().setDireccion("Belen Bolonia");
                edao.getEmpleado().setTelefono("0985583523");
                edao.getEmpleado().setCiudad("Loja");
                edao.getEmpleado().setId_rol(id_rol);
                System.out.println("id rolllllllllllllllllllllllllllllllllll: "+ edao.getEmpleado().getId_rol());
                edao.getEmpleado().setAnios_trabajo(2);
                edao.getEmpleado().setLicencia("");
                edao.getEmpleado().setSueldo(1500.00);
                edao.guardar();

                CuentaDao cdao = new CuentaDao();
                cdao.getCuenta().setContrasenia("1234");
                cdao.getCuenta().setId_persona(edao.getEmpleado().getId_persona());
                cdao.getCuenta().setUsuario(edao.getEmpleado().getCi_ruc());
                cdao.guardar();
                edao.setEmpleado(null);
                cdao.setCuenta(null);
                ((Rol)objeto).setId_rol(null);
                
                objeto = listado.busquedaBinaria("Secretario", "rol");
                id_rol = (objeto != null) ? ((Rol)objeto).getId_rol() : -1;
                //System.out.println("Se encontro Secreatiooooooo: " + id_rol);
                edao.getEmpleado().setNombre("Secretario");
                edao.getEmpleado().setCi_ruc("1150161097");
                edao.getEmpleado().setDireccion("Ciudad Victoria");
                edao.getEmpleado().setTelefono("0985426423");
                edao.getEmpleado().setCiudad("Loja");
                edao.getEmpleado().setId_rol(id_rol);
                //System.out.println("id rolllllllllllllllllllllllllllllllllll: "+ edao.getEmpleado().getId_rol());
                edao.getEmpleado().setAnios_trabajo(1);
                edao.getEmpleado().setLicencia("");
                edao.getEmpleado().setSueldo(400.00);
                edao.guardar();
                
                cdao.getCuenta().setContrasenia("4321");
                cdao.getCuenta().setId_persona(edao.getEmpleado().getId_persona());
                cdao.getCuenta().setUsuario(edao.getEmpleado().getCi_ruc());
                cdao.guardar();
                edao.setEmpleado(null);
                cdao.setCuenta(null);
            }
        }
    }
}
