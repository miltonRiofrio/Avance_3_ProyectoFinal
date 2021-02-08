/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.enums;

/**
 *
 * @author Sebastian
 */
public enum Categoria {
    A("Tecnologia y electronica"),
    B("hogar"),
    C("moda"),
    D("implementos deportivos"),
    E("oficina y papeleria"),
    F("salud e higiene"),
    G("musica"),
    H("juguetes"),
    I("alimentacion"),
    J("para mascotas");
 
    private String Categoria;

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    private Categoria(String Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString() {
        return Categoria;
    }
}

