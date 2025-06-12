package org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista.ArtistaJDBCImpl;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera.DisqueraJDBCImpl;
import org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero.GeneroJDBCImpl;
import org.Vázquez.Rojas.Diego.Alejandro.repository.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiscoJDBCImpl extends Conexion<Disco> implements DiscoJDBC
{
    private static DiscoJDBC discoJDBC;

    public DiscoJDBCImpl() {
    }

    public static DiscoJDBC getInstance()
    {
        if(discoJDBC==null)
        {
            discoJDBC=new DiscoJDBCImpl();
        }
        return discoJDBC;
    }

    @Override
    public List<Disco> findAll() {
        Statement statement= null;
        ResultSet resultSet= null;
        List<Disco>discos=null;
        Disco disco=null;
        String query= "SELECT * FROM DISCO";

        try
        {
            if(!openConnection())
            {
                System.out.println("Error en la conexion");
                return null;
            }
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            discos=new ArrayList<>();
            while (resultSet.next())
            {
                disco=new Disco();
                disco.setId(resultSet.getInt(1));
                disco.setTitulo(resultSet.getString(2));
                disco.setPrecio(resultSet.getFloat(3));
                disco.setExistencia(resultSet.getInt(4));
                disco.setDescuento(resultSet.getFloat(5));
                disco.setFecha(resultSet.getObject(6, LocalDate.class));
                disco.setImagen(resultSet.getString(7));
                disco.setArtista(ArtistaJDBCImpl.getInstance().findById(resultSet.getInt(8)));
                disco.setDisquera(DisqueraJDBCImpl.getInstance().findById(resultSet.getInt(9)));
                disco.setGenero(GeneroJDBCImpl.getInstance().findById(resultSet.getInt(10)));

                discos.add(disco);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return discos;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Disco disco)
    {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO DISCO (titulo,precio,existencia,descuento,fecha_lanzamiento,imagen,id_artista,id_disquera,id_genero_musical) values (?,?,?,?,?,?,?,?,?);";
        try {
            if(!openConnection()){
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,disco.getTitulo());
            preparedStatement.setFloat(2,disco.getPrecio());
            preparedStatement.setInt(3,disco.getExistencia());
            preparedStatement.setFloat(4,disco.getDescuento());
            preparedStatement.setObject(5,disco.getFecha());
            preparedStatement.setString(6,disco.getImagen());
            preparedStatement.setInt(7,disco.getArtista_id());
            preparedStatement.setInt(8,disco.getDisquera_id());
            preparedStatement.setInt(9,disco.getGenero_id());
            res=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Disco disco) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query = "UPDATE DISCO SET titulo=?, precio=?, existencia=?, descuento=?, fecha_lanzamiento=?, imagen=?, id_artista=?, id_disquera=?, id_genero_musical=? WHERE id=?";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,disco.getTitulo());
            preparedStatement.setFloat(2,disco.getPrecio());
            preparedStatement.setInt(3,disco.getExistencia());
            preparedStatement.setFloat(4,disco.getDescuento());
            preparedStatement.setObject(5,disco.getFecha());
            preparedStatement.setString(6,disco.getImagen());
            preparedStatement.setInt(7,disco.getArtista_id());
            preparedStatement.setInt(8,disco.getDisquera_id());
            preparedStatement.setInt(9,disco.getGenero_id());
            preparedStatement.setInt(10,disco.getId());
            res=preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Disco disco) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM DISCO WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, disco.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Disco findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<Disco>discos=null;
        Disco disco=null;
        String query="SELECT * FROM DISCO WHERE ID=%d";

        try
        {
            if (!openConnection())
            {
                System.out.println("Error en conexion");
                return null;
            }
            query=String.format(query, id);
            statement= connection.createStatement();
            resultSet=statement.executeQuery(query);
            discos=new ArrayList<>();
            if (resultSet.next())
            {
                disco=new Disco();
                disco.setId(resultSet.getInt(1));
                disco.setTitulo(resultSet.getString(2));
                disco.setPrecio(resultSet.getFloat(3));
                disco.setExistencia(resultSet.getInt(4));
                disco.setDescuento(resultSet.getFloat(5));
                disco.setFecha(resultSet.getObject(6, LocalDate.class));
                disco.setImagen(resultSet.getString(7));
                disco.setArtista(ArtistaJDBCImpl.getInstance().findById(resultSet.getInt(8)));
                disco.setDisquera(DisqueraJDBCImpl.getInstance().findById(resultSet.getInt(9)));
                disco.setGenero(GeneroJDBCImpl.getInstance().findById(resultSet.getInt(10)));
                discos.add(disco);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return disco;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
