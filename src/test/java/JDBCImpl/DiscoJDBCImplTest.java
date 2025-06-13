package JDBCImpl;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.Disco;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoJDBCImplTest {

    @Test
    void getInstance() {
        assertNotNull(DiscoJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        List<Disco> list = discoJDBC.findAll();
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
        Disco disco = new Disco();
        boolean res = false;
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Dangerous");
        disco.setPrecio(12.75F);
        disco.setExistencia(3590);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("1998-10-24").toLocalDate());
        disco.setImagen("Leon");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(2);
        res = discoJDBC.savetest(disco);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disco disco = new Disco();
        boolean res = false;
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Dangerous");
        disco.setPrecio(12.75F);
        disco.setExistencia(3590);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("1998-10-24").toLocalDate());
        disco.setImagen("Lion");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(2);
        disco.setId(2);
        res = discoJDBC.updatetest(disco);
        assertEquals(true, res);
    }
}