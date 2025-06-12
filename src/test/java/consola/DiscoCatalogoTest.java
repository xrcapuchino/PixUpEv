package consola;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.Disco;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoCatalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscoCatalogoTest {


    @Test
    void getInstance()
    {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        assertNotNull(discoCatalogo);
    }

    @Test
    void newT() {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        Disco disco = discoCatalogo.newT();
        assertNotNull(disco);
    }

    @Test
    void processNewT() {
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
        res = discoJDBC.save(disco);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
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
        res = discoJDBC.update(disco);
        assertEquals(true, res);
    }

    @Test
    void processList()
    {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        List<Disco> disco =  discoCatalogo.processList( );
        disco.forEach(System.out::println);
    }

    @Test
    void procesaOpcion( )
    {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        discoCatalogo.setOpcion( 4 );
        discoCatalogo.procesaOpcion( );
    }



}