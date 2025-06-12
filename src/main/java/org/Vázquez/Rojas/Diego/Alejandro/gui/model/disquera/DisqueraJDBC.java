package org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera;


import java.util.List;

public interface DisqueraJDBC
{

        List<Disquera> findAll();
        Disquera findById(Integer id);
        boolean save(Disquera disquera);
        boolean update(Disquera disquera);
        boolean delete(Disquera disquera);

}
