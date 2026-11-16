package com.example.veterinariaapi.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    void agregar(T item);
    List<T> listar();
    Optional<T> buscarPorId(Long id);
    boolean actualizar(Long id, T item);
    boolean eliminar(Long id);
}
