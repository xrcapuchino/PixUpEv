package org.Vázquez.Rojas.Diego.Alejandro.gui.model.catalogo;

public abstract class Catalogo
{
    protected Integer id;

    public Catalogo()
    {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                '}';
    }
}
