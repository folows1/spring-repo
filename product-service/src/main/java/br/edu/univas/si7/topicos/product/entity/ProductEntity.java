package br.edu.univas.si7.topicos.product.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class ProductEntity {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String name;
	private float price;
	private boolean active;
	
	
	
	public ProductEntity(int code, String name, float price, boolean active) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.active = active;
		this.createdAt = LocalDateTime.now();	
	}

	@Setter(AccessLevel.NONE)
	private LocalDateTime createdAt;
}
