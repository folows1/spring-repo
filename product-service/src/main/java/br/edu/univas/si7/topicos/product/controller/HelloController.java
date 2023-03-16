package br.edu.univas.si7.topicos.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.product.entity.ProductEntity;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping("/v1")
	public String hello() {
		return "Hello v1!";
	}
	
	@GetMapping("/v3")
	public ProductEntity hello3() {
		return new ProductEntity(1, "top", 32f, true);
	}
}
