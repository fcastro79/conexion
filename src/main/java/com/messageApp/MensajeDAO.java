package com.messageApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    public static void crearMensaje(Mensaje mensaje){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = Conexion.getConnection();

            String query="INSERT INTO mensajes(mensaje,autor_mensaje) VALUES(?,?)";
            ps=connection.prepareStatement(query);
            ps.setString(1,mensaje.getMensaje());
            ps.setString(2, mensaje.getAutorMensaje());
            ps.executeUpdate();
            System.out.println("Mensaje creado");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void leerMensajes(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = Conexion.getConnection();

            String query="select * from mensajes";
            ps=connection.prepareStatement(query);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                System.out.println("ID: "+ resultSet.getInt("id_mensaje"));
                System.out.println("Mensaje: "+ resultSet.getString("mensaje"));
                System.out.println("Mensaje: "+ resultSet.getString("autor_mensaje"));
                System.out.println("Mensaje: "+ resultSet.getDate("fecha_mensaje"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void borrarMensaje(int idMensaje){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = Conexion.getConnection();

            String query="delete from mensajes where id_mensaje = ?";
            ps=connection.prepareStatement(query);
            ps.setInt(1,idMensaje);
            int cant = ps.executeUpdate();
            if (cant>0){
                System.out.println("se pudo borrar correctamente");
            }else{
                System.out.println("No se encontro el registro");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void actualizarMensaje(Mensaje mensaje){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = Conexion.getConnection();

            String query="update mensajes set mensaje= ?, autor_mensaje=? where id_mensaje = ?";
            ps=connection.prepareStatement(query);
            ps.setString(1,mensaje.getMensaje());
            ps.setString(2,mensaje.getAutorMensaje());
            ps.setInt(3,mensaje.getIdMensaje());
            int cant = ps.executeUpdate();
            if (cant>0){
                System.out.println("se pudo borrar correctamente");
            }else{
                System.out.println("No se encontro el registro");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void cerrarConexion() {
        Conexion.cerrarConexion();
    }
}
