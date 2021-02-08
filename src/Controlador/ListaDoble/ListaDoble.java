/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ListaDoble;

import Controlador.Utiles;
import Modelo.Rol;

/**
 *
 * @author Milton Riofrio
 */
public class ListaDoble {

    protected NodoDE cabecera;
    public static final int ORDENAR_ASCENDENTE = -1;
    public static final int ORDENAR_DESCENDENTE = 1;

    public ListaDoble() {
        this.cabecera = null;
    }

    public boolean estaVacia() {
        return (this.cabecera == null);
    }

    public void insertar(Object dato) {

        if (estaVacia()) {
            NodoDE tmp = new NodoDE(dato, null, null);
            cabecera = tmp;
        } else {
            NodoDE tmp = new NodoDE(dato, null, null);
            NodoDE aux = cabecera;
            tmp.setSig(aux);
            aux.setAnt(tmp);
            cabecera = tmp;
        }
    }

    public void verDato() {
        if (!estaVacia()) {
            NodoDE tmp = cabecera;
            while (tmp != null) {
                System.out.println(tmp.getDato().toString());
                if (tmp.getAnt() != null) {
                    System.out.println("--- " + tmp.getAnt().getDato().toString() + " ---");
                }
                tmp = tmp.getSig();
            }
        }
    }

    public Object verDatoPos(int pos) {
        Object dato = null;
        if (!estaVacia() && pos >= 0) {
            NodoDE tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSig();
                if (tmp == null) {
                    break; //termina el proceso del ciclo for
                }
            }
            dato = (tmp != null) ? tmp.getDato() : null;
            //System.out.println(tmp.getDato());
        }
        return dato;
    }

    public int tamano() {
        int tamano = 0;
        if (!estaVacia()) {
            NodoDE tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSig();
            }
        }
        return tamano;
    }

    public Object obtenerPorPosicion(int pos) {
        Object aux = null;
        if (estaVacia() || pos < 0) {
            System.out.println("Vacio");

        } else if (pos > tamano() - 1) {

            throw new ArrayIndexOutOfBoundsException("Fuera de Rango");
        } else if (pos == 0) {
            aux = verDatoPos(pos);
        } else {
            NodoDE iterador = cabecera;
            for (int i = 1; i < pos; i++) {
                if (iterador.getSig().getSig() == null) {
                    break;
                }
                iterador = iterador.getSig();
            }
            aux = iterador.getSig().getDato();
        }
        return aux;
    }

    public Object obtenerPorPosicionLS(int pos) {
        Object r = null;
        if (!estaVacia()) {
            NodoDE tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSig();
                if (tmp == null) {
                    break;
                }
            }
            //System.out.println(tmp.getDato());
            if (tmp != null) {
                r = tmp.getDato();
            }
        }
        return r;
    }

    public Object buscarPorDato(Object dato) {
        Object auxdato = null;
        if (!estaVacia() && dato != null) {
            NodoDE iterador = cabecera;
            for (int i = 0; i < tamano(); i++) {
                if (iterador.getDato().equals(dato)) {
                    auxdato = iterador.getDato();
                    auxdato = auxdato + " en la posicion: " + i;
                    break;
                } else if (!iterador.getDato().equals(dato) && i == tamano() - 1) {
                    throw new ArrayIndexOutOfBoundsException("Dato Erroreo");
                }
                iterador = iterador.getSig();
            }
        } else {
            System.out.println("Vacio");
        }
        return auxdato;
    }

    public void editarPorPos(int pos, Object dato) {
        if (pos >= 0 && pos < tamano()) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoDE aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSig();
                }
                aux.setDato(dato);
            }
        } else {
            System.out.println("Fuera de rango");
        }
    }

    public void editar(int posicion, Object dato) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamano()) {
            // Consulta si el nodo a eliminar es el primero.
            if (posicion == 0) {
                // Alctualiza el valor delprimer nodo.
                cabecera.setDato(dato);
            } else {
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                NodoDE aux = cabecera;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSig();
                }
                // Alctualiza el valor del nodo.
                aux.setDato(dato);
            }
        }
    }

    public void insertar(Object dato, int pos) {
        if (estaVacia() || pos <= 0) {
            insertar(dato);
        } else {
            NodoDE iterador = this.cabecera;
            for (int i = 1; i < pos; i++) {
                if (iterador.getSig() == null) {
                    break;
                }
                iterador = iterador.getSig();
            }
            NodoDE tmp = new NodoDE(dato, iterador.getSig(), iterador);
            iterador.setSig(tmp);
            iterador = iterador.getSig();
            for (int i = pos; i < tamano() - 1; i++) {
                iterador = iterador.getSig();
                iterador.setAnt(tmp);
                tmp = tmp.getSig();
            }
        }
    }

    public Object busquedaBinaria(String dato, String atributo) {
        System.out.println("DATO " + dato + " ATRIBUTO " + atributo);
        int n = tamano();
        System.out.println(tamano());
        int centro, inf = 0, sup = n - 1;
        System.out.println("supppppp: " + sup);
        while (inf <= sup) {
            centro = (sup + inf) / 2;

            System.out.println("centro " + centro + " ss " + obtenerPorPosicion(centro) + " saa " + dato);
            //if ((String.valueOf(obtenerPorPosicion(centro))).equalsIgnoreCase(dato)) {
            System.out.println("Dato por pos: " + obtenerPorPosicion(centro));
            if (Utiles.comparar(dato,obtenerPorPosicion(centro), atributo)) {
                System.out.println("trueeeeeeeeeeeeeee");
                return obtenerPorPosicion(centro);
            } else if (Utiles.compareTo(dato, obtenerPorPosicion(centro), atributo) < 0) {//else if (dato.compareTo(String.valueOf(obtenerPorPosicion(centro))) < 0) {
                sup = centro - 1;
                System.out.println(" sup " + sup);
            } else {
                inf = centro + 1;
                System.out.println("inf " + inf);
            }

        }
        return null;
    }

    public void insertarFinal(String dato) {
        insertar(dato, tamano());
    }

    public void eliminarPorPos(int pos) {
        if (!estaVacia()) {
            if (pos < 0) {
                System.out.println("Debe ser una posicion mayor a cero");
            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSig();
                    cabecera.setAnt(null);
                } else if (pos <= (tamano() - 1)) {
                    NodoDE aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSig();
                    }
                    NodoDE siguiente = aux.getSig();
                    aux.setSig(siguiente.getSig());
                    if (aux.getSig() != null) {
                        aux.getSig().setAnt(siguiente.getAnt());
                    }
                } else {
                    System.out.println("No se elimino");
                }
            }
        } else {
            System.out.println("Lista Vacia");
        }
    }

    public void eliminarPorDato(String dato) {
        if (buscarPorDato(dato) != null) {
            if (cabecera.getDato().equals(dato)) {
                cabecera = cabecera.getSig();
                cabecera.setAnt(null);
            } else {
                NodoDE aux = cabecera;
                while (!(aux.getSig().getDato().equals(dato))) {
                    aux = aux.getSig();
                }
                NodoDE siguiente = aux.getSig().getSig();
                aux.setSig(siguiente);
                if (aux.getSig() != null) {
                    aux.getSig().setAnt(siguiente.getAnt().getAnt());
                }
            }
        } else {
            System.out.println("No existe el dato a eliminar");
        }
    }

    public ListaDoble ordenar(int tipo_ordenacion, String atributo) {
        if (!estaVacia()) {
            for (int i = 0; i < tamano() - 1; i++) {
                int k = i;
                for (int j = i + 1; j < tamano(); j++) {
                    if (Utiles.compareTo(obtenerPorPosicion(j), obtenerPorPosicion(k), atributo) == tipo_ordenacion) {
                        k = j;
                    }
                }

                Object aux = obtenerPorPosicion(i);
                editarPorPos(i, obtenerPorPosicion(k));
                editarPorPos(k, aux);
            }
        }
        return this;
    }
}
