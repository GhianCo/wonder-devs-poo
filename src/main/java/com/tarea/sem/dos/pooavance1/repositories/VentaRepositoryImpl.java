
package com.tarea.sem.dos.pooavance1.repositories;

import com.tarea.sem.dos.pooavance1.interfaces.IVentaRepository;
import com.tarea.sem.dos.pooavance1.models.Venta;
import java.util.ArrayList;
import java.util.List;

public class VentaRepositoryImpl implements IVentaRepository {
    private final List<Venta> ventas = new ArrayList<>();

    @Override
    public List<Venta> findAll() {
        return ventas;
    }

    @Override
    public void save(Venta venta) {
        ventas.add(venta);
    }

    @Override
    public Venta findById(String id) {
       throw new UnsupportedOperationException("No soportado."); 
    }
}