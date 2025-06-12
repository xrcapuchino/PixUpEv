package org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.catalogo.Catalogo;

public class Genero extends Catalogo
{
    private String descripcion;

    public Genero() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero='"+descripcion+'\''+
                ", id="+id;
    }
}
