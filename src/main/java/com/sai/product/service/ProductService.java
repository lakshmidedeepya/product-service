package com.sai.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sai.product.client.DiscountFeignClient;
import com.sai.product.model.DiscountRequest;
import com.sai.product.model.DiscountResponse;
import com.sai.product.model.Product;
import com.sai.product.model.ProductPrice;
import com.sai.product.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	
	@Autowired
	RestTemplate resttemplate;
	
	@Autowired
	DiscountFeignClient dfc;
	
	
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
	public ProductPrice getProductPrice(Integer id) {
		Product p=getProduct(id);
		DiscountRequest drq=new DiscountRequest();
			drq.category=p.category;
			drq.mrp=p.mrp;
			HttpEntity<DiscountRequest> dRequest = new HttpEntity<DiscountRequest>(drq);
		
			//DiscountResponse dr=resttemplate.postForEntity("http://discount-service/cal",dRequest , DiscountResponse.class).getBody();
			DiscountResponse dr=dfc.getProdPrice(drq);
		
		ProductPrice pp=new ProductPrice();
			pp.disres=dr;
			pp.pro=p;
		 
		return pp;
		
	}
}
