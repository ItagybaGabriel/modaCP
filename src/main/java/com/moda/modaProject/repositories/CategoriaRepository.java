package com.moda.modaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moda.modaProject.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria , Integer> {

}
