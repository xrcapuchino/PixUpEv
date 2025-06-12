package JDBCImpl;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.Cancion;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancionJDBCImplTest {

    @Test
    void getInstance() {
        assertNotNull(CancionJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        List<Cancion> list = cancionJDBC.findAll();
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
        Cancion cancion = new Cancion();
        boolean res = false;
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        cancion.setTitulo("Thriller");
        cancion.setDuracion(Time.valueOf("00:02:32"));
        cancion.setDisco_id(2);
        res = cancionJDBC.save(cancion);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setTitulo("helo");
        cancion.setDuracion(Time.valueOf("00:05:32"));
        cancion.setDisco_id(2);
        cancion.setId(2);
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        res = cancionJDBC.update(cancion);
        assertEquals(true, res);
    }
}