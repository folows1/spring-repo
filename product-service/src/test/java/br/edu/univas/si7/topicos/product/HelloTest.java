package br.edu.univas.si7.topicos.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.univas.si7.topicos.product.controller.HelloController;
import br.edu.univas.si7.topicos.product.entity.ProductEntity;

public class HelloTest {
	HelloController controller = new HelloController();
	
	@Test
	public void testHello() {
		String resultado = controller.hello();
		assertEquals("Hello v1!", resultado);
	}
	
	@Test
	public void testProductHello() {
		ProductEntity productE = controller.hello3();
		assertEquals(1, productE.getCode());
		assertEquals("top", productE.getName());
		assertEquals(32f, productE.getPrice());
		assertEquals(true, productE.isActive());
	}
}
