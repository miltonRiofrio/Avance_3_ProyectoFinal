/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.Dao.InterfazDao;
import com.thoughtworks.xstream.XStream;
import Controlador.ListaDoble.ListaDoble;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class AdaptadorDao implements InterfazDao {

    private Conexion conexion;
    private Class clazz;

    public AdaptadorDao(Conexion conexion, Class clazz) {
        this.conexion = conexion;
        this.clazz = clazz;
    }

    @Override
    public ListaDoble listar() {
        ListaDoble lista = new ListaDoble();
        try {
            lista = (ListaDoble) conexion.getXtrStream().fromXML(new FileReader(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
            //Object obj = xtrStream.fromXML(new FileReader(url+File.separatorChar+"horario.json") );

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void guardar(Object o) throws Exception {
        ListaDoble lista = listar();
        lista.insertar(o);
        System.out.println("tamanioooooooooooooooooooo: " + lista.tamano());
        //System.out.println("lista.............");
        //lista.verDato();
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
    }

    @Override
    public void eliminar(Object pos) throws Exception {
        ListaDoble lista = listar();
        lista.eliminarPorPos((int)pos);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
    }
    
    @Override
    public Boolean modificar(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }

}
