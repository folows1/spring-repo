package br.edu.univas.si7.topicos.product.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.univas.si7.topicos.product.entity.ProductEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
	
	@NotNull(message = "Code can not be null.")
	@Positive(message = "Code must not be negative.")
	private Integer code;
	
	@NotNull(message = "Name can not be null.")
	@NotEmpty(message = "Name can not be empty.")
	@Size(min = 5, max = 80, message = "The size must be between 5 and 80.")
	private String name;
	
	@NotNull(message = "Price can not be null.")
	@Positive(message = "Price must not be negative.")
	private float price;
	
//	private boolean active;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dateCreated;

	public ProductDTO(ProductEntity product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
		this.dateCreated = product.getCreatedAt();
//		this.active = product.isActive();
	}
}
