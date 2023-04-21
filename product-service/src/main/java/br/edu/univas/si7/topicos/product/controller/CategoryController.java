package br.edu.univas.si7.topicos.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.product.dto.CategoryDTO;
import br.edu.univas.si7.topicos.product.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> getAllCategories() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getProductById(@PathVariable Integer id) {
		CategoryDTO dto = new CategoryDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCategory(@RequestBody CategoryDTO cat) {
		service.createCategory(cat);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@RequestBody CategoryDTO dto, @PathVariable Integer id) {
		service.updateCategory(service.toEntity(dto), id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteCategory(id);
	}
}
