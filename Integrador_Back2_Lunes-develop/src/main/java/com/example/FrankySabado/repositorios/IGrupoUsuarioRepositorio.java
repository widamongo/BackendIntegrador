package com.example.FrankySabado.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGrupoUsuarioRepositorio extends org.springframework.data.repository.Repository<Object, Integer> {

    @Query(value = "SELECT usuario_id FROM grupo_usuarios WHERE grupo_id = :grupoId", nativeQuery = true)
    List<Integer> findUsuarioIdsByGrupoId(@Param("grupoId") Integer grupoId);
}