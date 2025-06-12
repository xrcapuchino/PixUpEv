package org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista;

import java.util.List;

public interface ArtistaJDBC
{
    List<Artista> findAll();
    Artista findById(Integer id);
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
}
