package com.tarea.sem.dos.pooavance1.models;

public class Usuario extends Persona {
    
    private String usuario;
    private String clave;

    public Usuario(String nombre, String apellido, String dni, String usuario, String clave) {
        super(nombre, apellido, dni);
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
