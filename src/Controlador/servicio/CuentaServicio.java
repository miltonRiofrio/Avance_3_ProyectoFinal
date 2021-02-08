/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;


import Controlador.Dao.CuentaDao;
import Modelo.Cuenta;

/**
 *
 * @author Milton Riofrio
 */
public class CuentaServicio {
    private CuentaDao obj = new CuentaDao();
    public Cuenta getCuenta() {
        return obj.getCuenta();
    }
    
    public Cuenta inicioSesion(String usaurio, String clave) {
        return obj.inicioSesion(usaurio, clave);
    }
}
