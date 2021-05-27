package com.sai.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sai.product.model.DiscountRequest;
import com.sai.product.model.DiscountResponse;


@FeignClient("discount-service")
public interface DiscountFeignClient {
  @PostMapping("/cal")
  public DiscountResponse getProdPrice(@RequestBody DiscountRequest drq);
}
