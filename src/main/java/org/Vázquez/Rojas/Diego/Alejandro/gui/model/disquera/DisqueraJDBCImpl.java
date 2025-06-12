package org.Vázquez.Rojas.Diego.Alejandro.gui.model.disquera;

import org.Vázquez.Rojas.Diego.Alejandro.repository.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisqueraJDBCImpl extends Conexion<Disquera> implements DisqueraJDBC {

    private static DisqueraJDBC disqueraJDBC;

    public DisqueraJDBCImpl() {
    }

    public static DisqueraJDBC getInstance() {
        if (disqueraJDBC == null) {
            disqueraJDBC = new DisqueraJDBCImpl();
        }
        return disqueraJDBC;
    }

    @Override
    public List<Disquera> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Disquera> disqueras = null;
        Disquera disquera = null;
        String query = "SELECT * FROM DISQUERA";

        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            disqueras = new ArrayList<>();
            while (resultSet.next()) {
                disquera = new Disquera();
                disquera.setId(resultSet.getInt(1));
                disquera.setNombre(resultSet.getString(2));
                disqueras.add(disquera);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return disqueras;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean save(Disquera disquera) {
        int res = 0;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO DISQUERA (nombre) values (?);";
        try {
            if (!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disquera.getNombre());
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
    public boolean update(Disquera disquera) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="UPDATE DISQUERA SET NOMBRE=? WHERE ID=?;";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,disquera.getNombre());
            preparedStatement.setInt(2,disquera.getId());
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
    public boolean delete(Disquera disquera) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM DISQUERA WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, disquera.getId());
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
    public Disquera findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<Disquera>disqueras=null;
        Disquera disquera=null;
        String query="SELECT * FROM DISQUERA WHERE ID=%d";

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
            disqueras=new ArrayList<>();
            if (resultSet.next())
            {
                disquera=new Disquera();
                disquera.setId(resultSet.getInt(1));
                disquera.setNombre(resultSet.getString(2));
                disqueras.add(disquera);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return disquera;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

