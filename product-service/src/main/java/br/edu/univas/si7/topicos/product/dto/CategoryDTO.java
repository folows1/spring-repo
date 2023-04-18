package br.edu.univas.si7.topicos.product.dto;

import br.edu.univas.si7.topicos.product.entity.CategoryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
	
	private Integer id;
	private String name;
	
	public CategoryDTO(CategoryEntity cat) {
		this.name = cat.getName();
	}
}
