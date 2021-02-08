/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablas;

import Controlador.ListaDoble.ListaDoble;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sebastian
 */
public class ModeloTablaHistorialEntrega extends AbstractTableModel {

    private ListaDoble entrega = new ListaDoble();

    public ListaDoble getEntrega() {
        return entrega;
    }

    public void setEntrega(ListaDoble entrega) {
        this.entrega = entrega;
    }

    @Override
    public int getRowCount() {
        return entrega.tamano();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Modelo.HistorialEntrega he = (Modelo.HistorialEntrega) entrega.verDatoPos(rowIndex);
        switch (columnIndex) {
            case 0:
                return he.getId_hist_entrega();
            case 1:
                return he.getCiudad_origen();
            case 2:
                return he.getCiudad_destino();
            case 3:
                return he.getCamionero().getCi_ruc();
            case 4:
                return he.getCamion().getPlaca();
            case 5:
                return he.getFecha_entrega();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "IdHEntrega";
            case 1:
                return "Ciudad Origen";
            case 2:
                return "Ciudad Destino";
            case 3:
                return "Cedula Camionero";
            case 4:
                return "Placa Camion";
            case 5:
                return "Fecha de Entrega";
            default:
                return null;
        }
    }
}
