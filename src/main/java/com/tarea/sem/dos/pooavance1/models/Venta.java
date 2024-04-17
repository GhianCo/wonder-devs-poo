package com.tarea.sem.dos.pooavance1.models;

import java.util.List;

public class Venta {

    private String comprobante;
    private String serie;
    private String numero;
    private String fecha;
    private double igv;
    private double subtotal;
    private double total;
    private boolean anulada;
    private String fechaanulacion;

    private Cliente cliente;
    private Usuario usuario;

    private List<Detalleventa> detalles;

    public Venta(String comprobante, String serie, String numero, String fecha, Cliente cliente, Usuario usuario, List<Detalleventa> detalles) {
        this.comprobante = comprobante;
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isAnulada() {
        return anulada;
    }

    public void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    public String getFechaanulacion() {
        return fechaanulacion;
    }

    public void setFechaanulacion(String fechaanulacion) {
        this.fechaanulacion = fechaanulacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalleventa> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(Detalleventa detalle) {
        detalles.add(detalle);
    }
}
