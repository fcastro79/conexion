package com.messageApp;

import java.util.Scanner;

public class Inicio {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("================================");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            opcion= scanner.nextInt();
            switch(opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    MensajeService.cerrarConexion();
                    break;
            }
        }while(opcion!=5);
    }
}
