package consola;



import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.Artista;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaCatalogo;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaJDBC;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaJDBCImpl;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArtistaCatalogoTest {

    @Test
    void getInstance()
    {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        assertNotNull(artistaCatalogo);
    }

    @Test
    void newT() {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        Artista artista = artistaCatalogo.newT();
        assertNotNull(artista);
    }

    @Test
    void processNewT() {
        Artista artista = new Artista();
        boolean res = false;
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        artista.setNombre("Michael Jackson");
        res = artistaJDBC.save(artista);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Bruno Mars");
        artista.setId(1);
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        res = artistaJDBC.update(artista);
        assertEquals(true, res);
    }

    @Test
    void processList()
    {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        List<Artista> artista =  artistaCatalogo.processList( );
        artista.forEach(System.out::println);
    }
    @Test
    void procesaOpcion( )
    {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        artistaCatalogo.setOpcion( 4 );
        artistaCatalogo.procesaOpcion( );
    }


}