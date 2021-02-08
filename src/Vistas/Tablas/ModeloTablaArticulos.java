/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablas;

import Controlador.ListaDoble.ListaDoble;
import Modelo.Articulo;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sebastian
 */
public class ModeloTablaArticulos extends AbstractTableModel {

    private ListaDoble articulos = new ListaDoble();

    public ListaDoble getArticulos() {
        return articulos;
    }

    public void setArticulos(ListaDoble articulos) {
        this.articulos = articulos;
    }

    @Override
    public int getRowCount() {
        return articulos.tamano();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Articulo a = (Articulo)articulos.verDatoPos(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getId_articulo();
            case 1:
                return a.getNombre_articulo();
            case 2:
                return a.getCantidad();
            case 3:
                return a.getCategoria();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id Articulo";
            case 1:
                return "Nombre Articulo";
            case 2:
                return "Cantidad";
           case 3:
                return "Categoria";
            default:
                return null;
        }
    }
}
