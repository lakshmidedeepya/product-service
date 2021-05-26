package com.sai.product.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.product.model.Product;
import com.sai.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodser;
@PostMapping
public Product createProduct(@RequestBody Product req) {
	return prodser.create(req);
	//return new Product();
}
@GetMapping
public List<Product> getProducts() {
	return  prodser.getAllProducts();
	//return null;
}
@GetMapping("{id}")
public Product getProduct(@PathVariable(required = true,name = "id") Integer productid) {
	return prodser.getProduct(productid);
	//return new Product();
	
}
}
