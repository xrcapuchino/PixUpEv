package consola;


import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.Genero;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroCatalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneroCatalogoTest {
    @Test
    void getInstance()
    {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        assertNotNull(generoCatalogo);
    }

    @Test
    void newT() {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        Genero genero = generoCatalogo.newT();
        assertNotNull(genero);
    }

    @Test
    void processNewT() {
        Genero genero = new Genero();
        boolean res = false;
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        genero.setDescripcion("Rolling");
        res = generoJDBC.save(genero);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Genero genero = new Genero();
        boolean res = false;
        genero.setDescripcion("Rolling Stone");
        genero.setId(1);
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        res = generoJDBC.update(genero);
        assertEquals(true, res);
    }

    @Test
    void processList()
    {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        List<Genero> genero =  generoCatalogo.processList( );
        genero.forEach(System.out::println);
    }
    @Test
    void procesaOpcion( )
    {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        generoCatalogo.setOpcion( 4 );
        generoCatalogo.procesaOpcion( );
    }

}