package com.sai.product.model;

import java.io.Serializable;


import com.sai.product.model.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequest implements Serializable{
	private static final long serialVersionUID = 5093689614568882151L;
	public ProductCategory category;
	public double mrp;
}
