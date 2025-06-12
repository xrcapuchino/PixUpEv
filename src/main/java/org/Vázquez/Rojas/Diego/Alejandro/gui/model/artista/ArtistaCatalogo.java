package org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.catalogo.Catalogos;
import org.Vázquez.Rojas.Diego.Alejandro.util.ReadUtil;

import java.util.List;

public class ArtistaCatalogo extends Catalogos<Artista>
{
    private static ArtistaCatalogo artistaCatalogo;
    private static ArtistaJDBC artistaJDBC;

    private ArtistaCatalogo()
    {
        super();
    }

    public static ArtistaCatalogo getInstance()
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo=new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Teclee un artista");
        artista.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("-------------------");
        System.out.println("Id del artista "+artista.getId());
        System.out.println("Artista a editar: " + artista.getNombre());
        System.out.println("Teclee el valor nuevo del artista");
        System.out.println("-------------------");
        artista.setNombre(ReadUtil.read());
    }

    @Override
    public List<Artista> processList()
    {
        if(artistaJDBC==null)
            {
                if(!loadArtistaJDBC())
                {
                    System.out.println("Error al cargar ArtistaJDBC");
                }
            }
            return artistaJDBC.findAll();
    }

    private boolean loadArtistaJDBC()
    {
        artistaJDBC= ArtistaJDBCImpl.getInstance();
        return artistaJDBC!=null;
    }


}
