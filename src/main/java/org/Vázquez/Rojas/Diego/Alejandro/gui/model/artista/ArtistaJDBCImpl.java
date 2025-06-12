package org.Vázquez.Rojas.Diego.Alejandro.gui.model.artista;


import org.Vázquez.Rojas.Diego.Alejandro.repository.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistaJDBCImpl extends Conexion<Artista> implements ArtistaJDBC
{

    private static ArtistaJDBC artistaJDBC;

    public ArtistaJDBCImpl(){}

    public static ArtistaJDBC getInstance(){
        if(artistaJDBC==null){
            artistaJDBC=new ArtistaJDBCImpl();
        }
        return artistaJDBC;
    }

    @Override
    public List<Artista> findAll() {
        Statement statement= null;
        ResultSet resultSet= null;
        List<Artista>artistas=null;
        Artista artista=null;
        String query= "SELECT * FROM ARTISTA";

        try
        {
            if(!openConnection())
            {
                System.out.println("Error en la conexion");
                return null;
            }
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            artistas=new ArrayList<>();
            while (resultSet.next())
            {
                artista=new Artista();
                artista.setId(resultSet.getInt(1));
                artista.setNombre(resultSet.getString(2));
                artistas.add(artista);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return artistas;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Artista artista)
    {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO ARTISTA (nombre) values (?);";
        try {
            if(!openConnection()){
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,artista.getNombre());
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
    public boolean update(Artista artista) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="UPDATE ARTISTA SET NOMBRE=? WHERE ID=?;";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,artista.getNombre());
            preparedStatement.setInt(2,artista.getId());
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
    public boolean delete(Artista artista) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM ARTISTA WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, artista.getId());
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
    public Artista findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<Artista>artistas=null;
        Artista artista=null;
        String query="SELECT * FROM ARTISTA WHERE ID=%d";

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
            artistas=new ArrayList<>();
            if (resultSet.next())
            {
                artista=new Artista();
                artista.setId(resultSet.getInt(1));
                artista.setNombre(resultSet.getString(2));
                artistas.add(artista);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return artista;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
