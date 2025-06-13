package org.Vázquez.Rojas.Diego.Alejandro.gui.model.cancion;

import org.Vázquez.Rojas.Diego.Alejandro.gui.model.disco.DiscoJDBCImpl;
import org.Vázquez.Rojas.Diego.Alejandro.repository.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CancionJDBCImpl extends Conexion<Cancion> implements CancionJDBC
{
    private static CancionJDBC cancionJDBC;

    public CancionJDBCImpl() {
    }

    public static CancionJDBC getInstance()
    {
        if(cancionJDBC==null)
        {
            cancionJDBC=new CancionJDBCImpl();
        }
        return cancionJDBC;
    }

    @Override
    public List<Cancion> findAll() {
        Statement statement= null;
        ResultSet resultSet= null;
        List<Cancion>cancions=null;
        Cancion cancion =null;
        String query= "SELECT * FROM CANCION";

        try
        {
            if(!openConnection())
            {
                System.out.println("Error en la conexion");
                return null;
            }
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            cancions=new ArrayList<>();
            while (resultSet.next())
            {
                cancion =new Cancion();
                cancion.setId(resultSet.getInt(1));
                cancion.setTitulo(resultSet.getString(2));
                cancion.setDuracion(resultSet.getTime(3));
                cancion.setDisco_id(resultSet.getInt( 4 ));
                cancions.add(cancion);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return cancions;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Cancion cancion)
    {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO CANCION(titulo,duracion,disco_id) values(?,?,?);";
        try {
            if(!openConnection()){
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,cancion.getTitulo());
            preparedStatement.setTime(2,cancion.getDuracion());
            preparedStatement.setInt(3,cancion.getDisco().getId());
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
    public boolean savetest(Cancion cancion)
    {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="INSERT INTO CANCION(titulo,duracion,disco_id) values(?,?,?);";
        try {
            if(!openConnection()){
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,cancion.getTitulo());
            preparedStatement.setTime(2,cancion.getDuracion());
            preparedStatement.setInt(3,cancion.getDisco_id());
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
    public boolean update(Cancion cancion) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query = "UPDATE CANCION SET titulo=?, duracion=?, disco_id=? WHERE id=?";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,cancion.getTitulo());
            preparedStatement.setTime(2,cancion.getDuracion());
            preparedStatement.setInt(3,cancion.getDisco_id());
            preparedStatement.setInt(4,cancion.getDisco().getId());
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
    public boolean updatetest(Cancion cancion) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query = "UPDATE CANCION SET titulo=?, duracion=?, disco_id=? WHERE id=?";
        try {
            if (!openConnection())
            {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,cancion.getTitulo());
            preparedStatement.setTime(2,cancion.getDuracion());
            preparedStatement.setInt(3,cancion.getDisco_id());
            preparedStatement.setInt(4,cancion.getId());
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
    public boolean delete(Cancion cancion) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String query="DELETE FROM CANCION WHERE ID = ?";
        try {
            if(!openConnection()) {
                System.out.println("Error en la conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cancion.getId());
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
    public Cancion findById(Integer id) {
        Statement statement=null;
        ResultSet resultSet=null;
        List<Cancion> cancions =null;
        Cancion cancion=null;
        String query="SELECT * FROM CANCION WHERE ID=%d";

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
            cancions =new ArrayList<>();
            if (resultSet.next())
            {
                cancion=new Cancion();
                cancion.setId(resultSet.getInt(1));
                cancion.setTitulo(resultSet.getString(2));
                cancion.setDuracion(resultSet.getTime(3));
                cancion.setDisco(DiscoJDBCImpl.getInstance().findById(resultSet.getInt(4)));
                cancions.add(cancion);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return cancion;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
