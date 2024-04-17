package com.tarea.sem.dos.pooavance1;

import com.tarea.sem.dos.pooavance1.models.Sesion;
import com.tarea.sem.dos.pooavance1.models.Menu;

public class PooAvance1 {

    private static final int MAX_INTENTOS = 3;

    public static void main(String[] args) {
        int intentos = 0;
        Sesion sesion = new Sesion();
        Menu menu = new Menu();

        while (intentos < MAX_INTENTOS) {
            if (sesion.iniciarSesion()) {
                menu.mostrarMenu();
                return;
            }
            intentos++;
        }

        System.out.println("Has superado el número máximo de intentos. Saliendo del sistema...");

    }
}
