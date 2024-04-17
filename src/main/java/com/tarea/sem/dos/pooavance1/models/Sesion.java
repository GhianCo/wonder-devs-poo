package com.tarea.sem.dos.pooavance1.models;

import java.util.List;
import java.util.Scanner;

public class Sesion {

    private Scanner scanner;
    private Storage storage;

    public Sesion() {
        this.scanner = new Scanner(System.in);
        this.storage = Storage.obtenerInstancia();
    }

    public boolean iniciarSesion() {
        System.out.println("=== Inicio de Sesión ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();
        Usuario login = iniciarSesion(usuario, clave);
        if (login != null) {
            storage.agregarUsuarioSesion(login);
            System.out.println("###############################################################");
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario + "!");
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrectos. Por favor, intente nuevamente.");
            return false;
        }
    }

    private Usuario iniciarSesion(String usuario, String clave) {
        List<Usuario> listaUsuarios = storage.getListaUsuarios();
        for (Usuario usuarioStorage : listaUsuarios) {
            if (usuarioStorage.getUsuario().equalsIgnoreCase(usuario) && usuarioStorage.getClave().equalsIgnoreCase(clave)) {
                return usuarioStorage;
            }
        }
        return null;
    }

    public void cerrarSesion() {
        this.storage.agregarUsuarioSesion(null);
        System.out.println("Sesión cerrada correctamente.");
    }
}
