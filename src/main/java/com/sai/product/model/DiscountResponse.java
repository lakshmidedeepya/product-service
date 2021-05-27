package com.sai.product.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiscountResponse implements Serializable{
	private static final long serialVersionUID = 509368145677682151L;
	public double mrp;
	public double drp;
	public double fixedCategoryDiscount;
	public double onSpotDiscount;
}
