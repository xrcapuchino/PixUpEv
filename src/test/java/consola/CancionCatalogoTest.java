package consola;


import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.Cancion;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionCatalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion.CancionJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CancionCatalogoTest {

    void getInstance()
    {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        assertNotNull(cancionCatalogo);
    }

    @Test
    void newT() {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        Cancion cancion = cancionCatalogo.newT();
        assertNotNull(cancion);
    }

    @Test
    void processNewT() {
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
    void processEditT() {
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

    @Test
    void processList()
    {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        List<Cancion> cancion =  cancionCatalogo.processList( );
        cancion.forEach(System.out::println);
    }
    @Test
    void procesaOpcion( )
    {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        cancionCatalogo.setOpcion( 4 );
        cancionCatalogo.procesaOpcion( );
    }



}