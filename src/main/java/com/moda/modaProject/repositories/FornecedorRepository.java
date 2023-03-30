package com.moda.modaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moda.modaProject.models.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
