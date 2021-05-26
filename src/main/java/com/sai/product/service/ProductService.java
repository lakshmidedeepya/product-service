package com.sai.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.product.model.Product;
import com.sai.product.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public Product create(Product pro) {
		return repo.save(pro);
		
	}
	public List<Product> getAllProducts() {
		List<Product> products=new ArrayList<>();
	 repo.findAll().forEach(product->products.add(product));
	 return products;
	}
	public Product getProduct(Integer id) {
		return repo.findById(id).get();
		
		
	}
}
