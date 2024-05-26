package com.tarea.sem.dos.pooavance1.models;

import com.tarea.sem.dos.pooavance1.interfaces.IClienteRepository;
import com.tarea.sem.dos.pooavance1.interfaces.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import com.tarea.sem.dos.pooavance1.interfaces.IUsuarioRepository;
import com.tarea.sem.dos.pooavance1.interfaces.IVentaRepository;
import com.tarea.sem.dos.pooavance1.repositories.ClienteRepositoryImpl;
import com.tarea.sem.dos.pooavance1.repositories.ProductoRepositoryImpl;
import com.tarea.sem.dos.pooavance1.repositories.UsuarioRepositoryImpl;
import com.tarea.sem.dos.pooavance1.repositories.VentaRepositoryImpl;

public class Storage {

    private static Storage instancia;
    private final IUsuarioRepository usuarioRepository;
    private final IProductoRepository productoRepository;
    private final IClienteRepository clienteRepository;
    private final IVentaRepository ventaRepository;
    private final List<Producto> productos = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Venta> ventas = new ArrayList<>();
    private Usuario usuarioSesion = null;

    private Storage() {
        this.usuarioRepository = new UsuarioRepositoryImpl();
        this.productoRepository = new ProductoRepositoryImpl();
        this.clienteRepository = new ClienteRepositoryImpl();
        this.ventaRepository = new VentaRepositoryImpl();
        
        usuarioRepository.save(new Usuario("Admin", "admin", "00000000", "root", "root"));

        Categoria categoria = new Categoria("Sin categoria");
        productoRepository.save(new Producto("Arroz", categoria, 2));
        productoRepository.save(new Producto("Azucar", categoria, 3));
        productoRepository.save(new Producto("Queso", categoria, 6));

        clienteRepository.save(new Cliente("Pedro", "Castillo", "47359833"));
        clienteRepository.save(new Cliente("Juan", "Moralez", "47359832"));

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
        return productoRepository.findAll();
    }

    public void agregarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Cliente> getListaClientes() {
        return clienteRepository.findAll();
    }

    public void agregarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Venta> getListaVentas() {
        return ventaRepository.findAll();
    }

    public void agregarVenta(Venta venta) {
         ventaRepository.save(venta);
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void agregarUsuarioSesion(Usuario usuario) {
        usuarioSesion = usuario;
    }

}
