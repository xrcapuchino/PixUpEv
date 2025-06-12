package JDBCImpl;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.Genero;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroJDBCImplTest {

    @Test
    void getInstance() {
        assertNotNull(GeneroJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        List<Genero> list = generoJDBC.findAll();
        if(list == null || list.isEmpty())
        {
            System.out.println("No hay elementos");
            return;
        }
        list.stream().forEach( e-> System.out.println(e.toString()));
        assertNotNull(list);
        assertTrue(list.size() >= 1);

    }

    @Test
    void save() {
        Genero genero = new Genero();
        boolean res = false;
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        genero.setDescripcion("top");
        res = generoJDBC.save(genero);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Genero genero = new Genero();
        boolean res = false;
        genero.setDescripcion("POP");
        genero.setId(2);
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        res = generoJDBC.update(genero);
        assertEquals(true, res);
    }
}