package com.tarea.sem.dos.pooavance1.models;

import java.util.ArrayList;
import java.util.List;
import com.tarea.sem.dos.pooavance1.interfaces.IUsuarioRepository;
import com.tarea.sem.dos.pooavance1.repositories.UsuarioRepositoryImpl;

public class Storage {

    private static Storage instancia;
    private final IUsuarioRepository usuarioRepository;
    private final List<Producto> productos = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Venta> ventas = new ArrayList<>();
    private Usuario usuarioSesion = null;

    private Storage() {
        this.usuarioRepository = new UsuarioRepositoryImpl();

        usuarioRepository.save(new Usuario("Admin", "admin", "00000000", "root", "root"));

        Categoria categoria = new Categoria("Sin categoria");
        productos.add(new Producto("Arroz", categoria, 2));
        productos.add(new Producto("Azucar", categoria, 3));
        productos.add(new Producto("Queso", categoria, 6));

        clientes.add(new Cliente("Pedro", "Castillo", "47359833"));
        clientes.add(new Cliente("Juan", "Moralez", "47359832"));

    }

    public static Storage obtenerInstancia() {
        if (instancia == null) {
            instancia = new Storage();
        }
        return instancia;
    }

    public List<Usuario> getListaUsuarios() {
        return usuarioRepository.findAll();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Producto> getListaProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Cliente> getListaClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Venta> getListaVentas() {
        return ventas;
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void agregarUsuarioSesion(Usuario usuario) {
        usuarioSesion = usuario;
    }

}
