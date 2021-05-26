package com.sai.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.sai.product.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

}
