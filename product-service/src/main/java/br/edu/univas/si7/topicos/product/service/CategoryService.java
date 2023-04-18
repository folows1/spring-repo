package br.edu.univas.si7.topicos.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.topicos.product.dto.CategoryDTO;
import br.edu.univas.si7.topicos.product.entity.CategoryEntity;
import br.edu.univas.si7.topicos.product.repository.CategoryRepository;
import br.edu.univas.si7.topicos.product.support.ObjectNotFoundException;
import br.edu.univas.si7.topicos.product.support.ProductException;

@Service
public class CategoryService {
	private CategoryRepository repo;
	
	@Autowired
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	public List<CategoryDTO> findAll() {
		return repo.findAll().stream().map(p -> new CategoryDTO(p)).collect(Collectors.toList());
	}

	public CategoryEntity findById(Integer id) {
		Optional<CategoryEntity> obj = repo.findById(id);
		CategoryEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Category " + id + " not found"));
		return entity;
	}
	
	public void createCategory(CategoryDTO cat) {
		repo.save(toEntity(cat));
	}

	public CategoryEntity toEntity(CategoryDTO cat) {
		return new CategoryEntity(cat.getId(), cat.getName());
	}

	public void updateCategory(CategoryEntity cat, Integer id) {
		if (id == null || cat == null || !id.equals(cat.getId())) {
			throw new ProductException("Invalid cat id.");
		}
		CategoryEntity existingObj = findById(id);
		updateData(existingObj, cat);
		repo.save(existingObj);
	}

	private void updateData(CategoryEntity existingObj, CategoryEntity obj) {
		existingObj.setName(obj.getName());
	}

	public void deleteCategory(Integer id) {
		if (id == null) {
			throw new ProductException("Category id can not be null.");
		}
		CategoryEntity obj = findById(id);
		try {
			repo.delete(obj);
			// desativar o produto (ao invés de deletar)
		} catch (DataIntegrityViolationException e) {
			throw new ProductException("Can not delete a Category with dependencies constraints.");
		}
	}
	
	
}
