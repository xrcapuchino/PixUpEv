package JDBCImpl;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.Artista;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaJDBCImplTest {

    @Test
    void getInstance() {
        assertNotNull(ArtistaJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        List<Artista> list = artistaJDBC.findAll();
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
        Artista artista = new Artista();
        boolean res = false;
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        artista.setNombre("Michael Jackson");
        res = artistaJDBC.save(artista);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Bruno Mars");
        artista.setId(1);
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        res = artistaJDBC.update(artista);
        assertEquals(true, res);
    }
}