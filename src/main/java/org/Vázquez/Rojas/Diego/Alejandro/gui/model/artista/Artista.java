package org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.catalogo.Catalogo;

public class Artista extends Catalogo
{
    private String nombre;

    public Artista() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "artista='"+nombre+'\''+
                ", id="+id;
    }
}
