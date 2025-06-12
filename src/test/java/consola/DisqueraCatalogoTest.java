package consola;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.Disquera;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.DisqueraCatalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.DisqueraJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.DisqueraJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DisqueraCatalogoTest {
    @Test
    void getInstance()
    {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        assertNotNull(disqueraCatalogo);
    }

    @Test
    void newT() {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        Disquera disquera = disqueraCatalogo.newT();
        assertNotNull(disquera);
    }

    @Test
    void processNewT() {
        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        disquera.setNombre("Rolling");
        res = disqueraJDBC.save(disquera);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("Rolling Stone");
        disquera.setId(1);
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        res = disqueraJDBC.update(disquera);
        assertEquals(true, res);
    }

    @Test
    void processList()
    {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        List<Disquera> disquera =  disqueraCatalogo.processList( );
        disquera.forEach(System.out::println);
    }
    @Test
    void procesaOpcion( )
    {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        disqueraCatalogo.setOpcion( 4 );
        disqueraCatalogo.procesaOpcion( );
    }

}