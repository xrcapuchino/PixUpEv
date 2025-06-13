package org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco;


import java.util.List;

public interface DiscoJDBC
{

    List<Disco>findAll();
    Disco findById(Integer id);
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean savetest(Disco disco);
    boolean updatetest(Disco disco);
    boolean delete(Disco disco);

}
