package org.Vázquez.Rojas.Diego.Alejandro.gui.model.genero;


import org.Vázquez.Rojas.Diego.Alejandro.repository.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroJDBCImpl extends Conexion<Genero> implements GeneroJDBC
{
    private static GeneroJDBC generoJDBC;

    public GeneroJDBCImpl() {
    }

    public static GeneroJDBC getInstance()
    {
        if(generoJDBC==null)
        {
            generoJDBC=new GeneroJDBCImpl();
        }
        return generoJDBC;
    }

    @Override
    public List<Genero> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Genero> generos = null;
        Genero genero = null;
        String query = "SELECT * FROM GENERO_MUSICAL";

        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            generos = new ArrayList<>();
            while (resultSet.next()) {
                genero = new Genero();
                genero.setId(resultSet.getInt(1));
                genero.setDescripcion(resultSet.getString(2));
                generos.add(genero);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return generos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Genero genero) {
        int res = 0;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO GENERO_MUSICAL (descripcion) values (?);";
        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genero.getDescripcion());
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
    public boolean update(Genero genero) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="UPDATE GENERO_MUSICAL SET DESCRIPCION=? WHERE ID=?;";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,genero.getDescripcion());
            preparedStatement.setInt(2,genero.getId());
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
    public boolean delete(Genero genero) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM GENERO_MUSICAL WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, genero.getId());
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
    public Genero findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<Genero>generos=null;
        Genero genero=null;
        String query="SELECT * FROM GENERO_MUSICAL WHERE ID=%d";

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
            generos=new ArrayList<>();
            if (resultSet.next())
            {
                genero=new Genero();
                genero.setId(resultSet.getInt(1));
                genero.setDescripcion(resultSet.getString(2));
                generos.add(genero);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return genero;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
