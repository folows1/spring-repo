package br.edu.univas.si7.topicos.product.dto;

import br.edu.univas.si7.topicos.product.entity.ProductEntity;
import lombok.Data;

@Data
public class ProductDTO {
	private Integer code;
	private String name;
	private float price;
//	private boolean active;

	public ProductDTO(ProductEntity product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
//		this.active = product.isActive();
	}
}
