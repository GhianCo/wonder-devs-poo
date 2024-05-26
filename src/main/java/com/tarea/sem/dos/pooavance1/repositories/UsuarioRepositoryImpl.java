package com.tarea.sem.dos.pooavance1.repositories;

import com.tarea.sem.dos.pooavance1.interfaces.IUsuarioRepository;
import com.tarea.sem.dos.pooavance1.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements IUsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public List<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Usuario findById(String id) {
        throw new UnsupportedOperationException("No soportado."); 
    }

}
