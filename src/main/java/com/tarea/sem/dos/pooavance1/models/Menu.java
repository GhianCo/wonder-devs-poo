package com.tarea.sem.dos.pooavance1.models;

import com.tarea.sem.dos.pooavance1.PooAvance1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Storage storage;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.storage = Storage.obtenerInstancia();
    }

    public void mostrarMenu() {
        int opcion;
        do {

            int cantProductos = storage.getListaProductos().size();
            int cantClientes = storage.getListaClientes().size();
            int cantVentas = storage.getListaVentas().size();

            System.out.println("=== Menú Principal ===");
            System.out.println("1. Realizar una venta " + (cantVentas > 0 ? "(" + cantVentas + ")" : ""));
            System.out.println("2. Registrar un cliente " + (cantClientes > 0 ? "(" + cantClientes + ")" : ""));
            System.out.println("3. Agregar productos " + (cantProductos > 0 ? "(" + cantProductos + ")" : ""));
            System.out.println("4. Cerrar sesión");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    realizarVenta();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    agregarProductos();
                    break;
                case 4:
                    cerrarSesion();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private void realizarVenta() {
        System.out.println("=== Realizar Venta ===");
        Cliente cliente = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        do {
            System.out.print("Ingrese el DNI del cliente (o 'salir' para regresar al menú principal): ");
            String dniCliente = scanner.nextLine();
            if (dniCliente.equalsIgnoreCase("salir")) {
                return;
            }
            cliente = buscarClientePorDNI(dniCliente);
            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
            }
        } while (cliente == null);

        String comprobante = null;
        do {
            System.out.print("Ingrese el comprobate (o 'salir' para regresar al menú principal): ");
            String comprobanteBusqueda = scanner.nextLine();
            if (comprobanteBusqueda.equalsIgnoreCase("salir")) {
                return;
            }
            comprobante = buscarComprobante(comprobanteBusqueda);
            if (comprobante == null) {
                System.out.println("Comprobante no encontrado.");
            }
        } while (comprobante == null);

        System.out.print("Ingrese la serie: ");
        String serie = scanner.nextLine();

        System.out.print("Ingrese el numero: ");
        String numero = scanner.nextLine();

        List<Detalleventa> detalleventa = new ArrayList<>();
        System.out.println("=== Busqueda de productos Productos ===");
        do {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            Producto producto = buscarProductoPorNombre(nombreProducto);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            detalleventa.add(new Detalleventa(producto, cantidad, producto.getPrecio()));

            System.out.print("¿Desea agregar otro producto? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

        storage.agregarVenta(new Venta(comprobante, serie, numero, dateFormat.format(date), cliente, storage.getUsuarioSesion(), detalleventa));

        System.out.println("Venta realizada correctamente.");
    }

    private void registrarCliente() {

        System.out.println("=== Registro de Cliente ===");
        do {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el DNI del cliente: ");
            String dni = scanner.nextLine();

            Cliente cliente = new Cliente(nombre, apellido, dni);
            storage.agregarCliente(cliente);

            System.out.println("Cliente registrado correctamente.");

            System.out.print("¿Desea agregar otro cliente? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));

    }

    private void agregarProductos() {

        Categoria categoria = new Categoria("General");

        System.out.println("=== Agregar Productos ===");
        do {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            Producto producto = new Producto(nombre, categoria, precio);
            storage.agregarProducto(producto);

            System.out.println("Producto agregado correctamente.");

            System.out.print("¿Desea agregar otro producto? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("s"));
    }

    private void cerrarSesion() {
        Sesion sesion = new Sesion();
        sesion.cerrarSesion();
        PooAvance1.main(new String[]{});
    }

    private Cliente buscarClientePorDNI(String dni) {
        List<Cliente> clientes = storage.getListaClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    private String buscarComprobante(String comprobante) {
        String[] comprobantes = new String[]{"Boleta", "Factura", "Nota de venta"};
        for (String comprobanteStorage : comprobantes) {
            if (comprobanteStorage == null ? comprobante == null : comprobanteStorage.equals(comprobante)) {
                return comprobanteStorage;
            }
        }
        return null;
    }

    private Producto buscarProductoPorNombre(String nombre) {
        List<Producto> productos = storage.getListaProductos();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

}
