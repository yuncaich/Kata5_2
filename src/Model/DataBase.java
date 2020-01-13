package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
    String url;
    Connection connection = null;
    public HashMap<String,String> components = new HashMap<String,String>();
    
    public DataBase (String url) {
        this.url = url;
    }
    
    public void open () {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de datos abierta");
        } catch (SQLException ex) {
            System.out.println("ERROR AL ABRIR BASE DE DATOS " + ex.getMessage());
        }
    }

    public void close() {
        if (connection != null) {
            try {
                this.connection.close();
                System.out.println("Base de datos cerrada");
            } catch (SQLException ex) {
                System.out.println("ERROR AL CERRAR BASE DE DATOS " + ex.getMessage());
            }
        }
    }

    public void insert(String name, String newspaper) {
        String SQL = "INSERT INTO PRUEBA (NOMBRE, PERIODICO) VALUES (?,?)";
        try {
            PreparedStatement preparestatement = this.connection.prepareStatement(SQL);
            preparestatement.setString(1, name);
            preparestatement.setString(2, newspaper);
            preparestatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR AL INSERTAR EN BASE DE DATOS " + ex.getMessage());
        }
    }

    public void select() {
        String SQL  = "SELECT * FROM PRUEBA";
        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            while (resultset.next()) {
                this.components.put(resultset.getString("NOMBRE"), resultset.getString("PERIODICO"));
                System.out.println(resultset.getString("NOMBRE") + " " + resultset.getString("PERIODICO"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL SELECCIONAR EN BASE DE DATOS " + ex.getMessage());
        }
    }
}