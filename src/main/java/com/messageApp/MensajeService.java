package com.messageApp;

import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = scanner.nextLine();
        System.out.println("Escribe tu nombre");
        String autor = scanner.nextLine();
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(autor);
        MensajeDAO.crearMensaje(registro);
    }

    public static void listarMensaje(){
       MensajeDAO.leerMensajes();
    }

    public static void borrarMensaje(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("ingrese el id del mensaje a borrar");
        int idMensaje=scanner.nextInt();
        MensajeDAO.borrarMensaje(idMensaje);
    }

    public static void editarMensaje(){

    }

    public static void cerrarConexion() {
        MensajeDAO.cerrarConexion();
    }
}
