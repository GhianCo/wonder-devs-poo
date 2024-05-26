
package com.tarea.sem.dos.pooavance1.repositories;

import com.tarea.sem.dos.pooavance1.interfaces.IClienteRepository;
import com.tarea.sem.dos.pooavance1.models.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements IClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente findById(String id) {
       throw new UnsupportedOperationException("No soportado."); 
    }
}