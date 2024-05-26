
package com.tarea.sem.dos.pooavance1.repositories;

import com.tarea.sem.dos.pooavance1.interfaces.IProductoRepository;
import com.tarea.sem.dos.pooavance1.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements IProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto findById(String id) {
      throw new UnsupportedOperationException("No soportado."); 
    }
}