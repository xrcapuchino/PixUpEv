package org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero;

import java.util.List;

public interface GeneroJDBC
{

    List<Genero> findAll();
    Genero findById(Integer id);
    boolean save(Genero genero);
    boolean update(Genero genero);
    boolean delete(Genero genero);

}
