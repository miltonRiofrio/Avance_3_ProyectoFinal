/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablas;

import Controlador.ListaDoble.ListaDoble;
import Modelo.HistorialEntrega;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sebastian
 */
public class ModeloTablaCamionero  extends AbstractTableModel {
    private ListaDoble camionero = new ListaDoble();

    public ListaDoble getCamionero() {
        return camionero;
    }

    public void setCamionero(ListaDoble camionero) {
        this.camionero = camionero;
    }

    @Override
    public int getRowCount() {
        return camionero.tamano();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HistorialEntrega he = (HistorialEntrega)camionero.verDatoPos(rowIndex);
        switch (columnIndex) {
            case 0:
                return he.getCamionero().getNombre();
            case 1:
                return he.getCamion().getPlaca();
            case 2:
                return he.getId_hist_entrega();
            case 3:
                return he.getCamionero().getCi_ruc();
            case 4:
                return he.getCamionero().getLicencia();
            case 5:
                return he.getCamionero().getSueldo();
            case 6:
                return he.getCamionero().getAnios_trabajo();
            case 7:
                return he.getCamionero().getCiudad();
            case 8:
                return he.getCamionero().getDireccion();
            case 9:
                return he.getCamionero().getTelefono();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre Conductor";
            case 1:
                return "Placa";
            case 2:
                return "IdHEntrega";
            case 3:
                return "Cedula";
            case 4:
                return "Licencia";
            case 5:
                return "Sueldo";
            case 6:
                return "Años de Trabajo";
            case 7:
                return "Ciudad";
            case 8:
                return "Direccion";
            case 9:
                return "Telefono";
            default:
                return null;
        }
    }
}
