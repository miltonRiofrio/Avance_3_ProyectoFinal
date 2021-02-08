/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.enums.Capacidad;
import Modelo.enums.Categoria;
import Modelo.enums.Prioridad;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.swing.JComboBox;


/**
 *
 * @author Sebastian
 */
public class Utiles {

    public static int compareTo(Object o, Object o1, String atributoClase) {
        int i = 0;
        if (o instanceof Integer && o1 instanceof Integer) {
            Integer uno = (Integer) o;
            Integer dos = (Integer) o1;
            if (uno > dos) {
                i = 1;
            } else if (uno < dos) {
                i = -1;
            }

        } else {
            String uno = extracciondato(o, atributoClase);
            String dos = extracciondato(o1, atributoClase);
            if (uno != null && dos != null) {
                if (uno.toUpperCase().compareTo(dos.toUpperCase()) > 0) {
                    i = 1;
                } else {
                    i = -1;
                }
            } 
        }

        /*  if (o instanceof Estudainte && o1 instanceof Estudainte) {
            Estudainte uno = (Estudainte) o;
            Estudainte dos = (Estudainte) o1;
            //i = uno.getApellidos().toUpperCase().compareTo(dos.getApellidos().toUpperCase());
            if (uno.getApellidos().toUpperCase().compareTo(dos.getApellidos().toUpperCase()) > 0) {
                i = 1;
            } else {
                i = -1;
            }
        }

        if (o instanceof Rol && o1 instanceof Rol) {
            Rol uno = (Rol) o;
            Rol dos = (Rol) o1;
            //i = uno.getApellidos().toUpperCase().compareTo(dos.getApellidos().toUpperCase());
            if (uno.getNombre().toUpperCase().compareTo(dos.getNombre().toUpperCase()) > 0) {
                i = 1;
            } else {
                i = -1;
            }
        }*/
        return i;
    }

    public long factorial(long num) {

        if (num == 0) {
            return 1l;
        } else {
            return num * factorial(num - 1);
        }
    }

    public long factorialOther(long num) {
        long numero = 1;

        for (long i = 1; i <= num; i++) {
            numero = numero * i;
            System.out.println("*** " + i);
        }

        return numero;
    }

    private static String extracciondato(Object obj, String atributoClase) {
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        System.out.println("claseeee: " + clase);
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
                System.out.println("atribuuuuuuutooooooo: " + atributo);
            }
        }
        if (atributo != null) {
            //  Method metodo = null;
            for (Method metodoAux : clase.getMethods()) {
                System.out.println("getttttt: " + metodoAux.getName().startsWith("get"));
                if (metodoAux.getName().startsWith("get")) {
                    //System.out.println("getttttt: " + metodoAux.getName().startsWith("get"));
                    System.out.println("terminar connnn: " + metodoAux.getName().toLowerCase().endsWith(atributo.getName()));
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(obj);
                            System.out.println("informacionnnnnn: " +informacion);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo " + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
    }

    public static Boolean comparar(String uno, Object obj, String atributoClase) {
        System.out.println("objjjj: " + obj.toString());
        System.out.println("atributoclaseeeee: " + atributoClase);
        String dos = extracciondato(obj, atributoClase);
        //System.out.println("COMPARAR DATOS " + uno + "   " + dos);
        System.out.println("dossssss: " + dos);
        return (dos != null) ? uno.equals(dos.toString()) : false;
    }
    
    public static int comparareTo(String uno, Object obj, String atributoClase) {
        String dos = extracciondato(obj, atributoClase);
        System.out.println("COMPARAR DATOS " + uno + "   " + dos);
        return (dos != null) ? uno.compareTo(dos.toString()) : -1;
    }

    public Boolean compararRigido(String uno, String dos) {
        return uno.equals(dos);
    }
    
    //*******categoria enums***********
    public static void cargarComboCategorias(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerCategorias().length; i++) {
            cbx.addItem(Utiles.obtenerCategorias()[i]);
        }
    }
    
    public static Categoria obtenerCategorias(JComboBox cbx) {
        return (Categoria) cbx.getSelectedItem();
    }
    
    public static Categoria[] obtenerCategorias() {
        return Categoria.values();
    }
    
    //****************capacidad enums**************
    public static void cargarComboCapacidades(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerCapacidades().length; i++) {
            cbx.addItem(Utiles.obtenerCapacidades()[i]);
        }
    }
    
    public static Capacidad obtenerCapacidades(JComboBox cbx) {
        return (Capacidad) cbx.getSelectedItem();
    }
    
    public static Capacidad[] obtenerCapacidades() {
        return Capacidad.values();
    }
    
    //***************prioridad***************
    public static void cargarComboPrioridades(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerPrioridades().length; i++) {
            cbx.addItem(Utiles.obtenerPrioridades()[i]);
        }
    }
    
    public static Prioridad obtenerPrioridades(JComboBox cbx) {
        return (Prioridad) cbx.getSelectedItem();
    }
    
    public static Prioridad[] obtenerPrioridades() {
        return Prioridad.values();
    }
}
