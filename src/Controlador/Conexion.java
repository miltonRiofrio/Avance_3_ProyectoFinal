/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 *
 * @author Sebastian
 */
public class Conexion {
    private final String REPO = "datos";
    private XStream xtrStream; 
    
    public Conexion() {
        xtrStream = new XStream(new JettisonMappedXmlDriver());
        xtrStream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
    }

    public String getREPO() {
        return REPO;
    }

    public XStream getXtrStream() {
        return xtrStream;
    }
}
