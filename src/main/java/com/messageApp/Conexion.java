package com.messageApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection= null;

    public static Connection getConnection(){
        if(connection==null){
            try{
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
