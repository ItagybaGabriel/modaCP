package com.moda.modaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moda.modaProject.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
