package com.poscoict.aoptest.service;

import org.springframework.stereotype.Service;
import com.poscoict.aoptest.vo.ProductVo;

@Service
public class ProductService {

	public ProductVo find(String name) {
		System.out.println("ProductService finding...");
		return new ProductVo(name);
	}
}
