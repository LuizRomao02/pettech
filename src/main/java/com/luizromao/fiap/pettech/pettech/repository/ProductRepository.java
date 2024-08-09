package com.luizromao.fiap.pettech.pettech.repository;

import com.luizromao.fiap.pettech.pettech.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
