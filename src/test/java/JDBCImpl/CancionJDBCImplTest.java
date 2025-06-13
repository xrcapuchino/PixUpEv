package JDBCImpl;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.Cancion;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
        cancion.setTitulo("yolo");
        cancion.setDuracion(Time.valueOf("00:03:53"));
        cancion.setDisco_id(1);
        res = cancionJDBC.savetest(cancion);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setTitulo("why");
        cancion.setDuracion(Time.valueOf("00:01:53"));
        cancion.setDisco_id(1);
        cancion.setId(1);
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        res = cancionJDBC.updatetest(cancion);
        assertEquals(true, res);
    }
}