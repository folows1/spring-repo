package br.edu.univas.si7.topicos.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.product.entity.CategoryEntity;
import br.edu.univas.si7.topicos.product.entity.ProductEntity;
import br.edu.univas.si7.topicos.product.repository.CategoryRepository;
import br.edu.univas.si7.topicos.product.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository catRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	//implementar usando os próximos passos
		
		ProductEntity p1 = new ProductEntity(1, "Arroz", 7.30f, true);
		repo.save(p1);
		ProductEntity p2 = new ProductEntity(2, "Feijão", 5.67f, true);
		repo.save(p2);
		
		CategoryEntity c1 = new CategoryEntity(1, "Categoria 1");
		CategoryEntity c2 = new CategoryEntity(2, "Categoria 2");
		catRepo.save(c1);
		catRepo.save(c2);
	}

}
