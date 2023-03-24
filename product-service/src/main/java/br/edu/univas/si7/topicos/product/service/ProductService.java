package br.edu.univas.si7.topicos.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.topicos.product.dto.ProductDTO;
import br.edu.univas.si7.topicos.product.entity.ProductEntity;
import br.edu.univas.si7.topicos.product.repository.ProductRepository;
import br.edu.univas.si7.topicos.product.support.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<ProductDTO> findAll() {
		return repo.findAll().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}

	public ProductDTO findById(Integer code) {
		Optional<ProductEntity> obj = repo.findById(code);
//		if (obj.isPresent()) {
//			return obj.get();
//		}
//		return obj.orElseThrow(() -> new ObjectNotFoundException("Product " + code + " not found"));
		ProductEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + code));
		return new ProductDTO(entity);
	}
	
	public List<ProductDTO> findAllActive() {
		return repo.findByActive(true).stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
}
