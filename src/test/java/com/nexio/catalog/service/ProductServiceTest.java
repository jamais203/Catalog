package com.nexio.catalog.service;


import com.nexio.catalog.model.Product;
import com.nexio.catalog.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService = new ProductService();

    @BeforeEach
    void setUp(){
        when(productRepository.findById(-1L)).thenReturn(Optional.of(new Product(-1L, "Chair", 75.0, "Best chair ever")));


        List<Product> products = getProducts();
        when(productRepository.findAll()).thenReturn(new Iterable<Product>() {
            @Override
            public Iterator<Product> iterator() {
                return products.iterator();
            }
        });
    }

    @Test
    public void testGetById(){
        Product product = productService.getProductById(-1L);
        assertEquals("Chair", product.getTitle());
        assertEquals("Best chair ever", product.getDescription());
        assertEquals(-1L, product.getId());
        assertEquals(75.0, product.getPrice());
    }

    @Test
    public void testGetAll(){
    List<Product> products = productService.getProducts();
    assertEquals(3, products.size());
    assertEquals(4.0, products.get(1).getPrice());
    }

    private List<Product> getProducts(){

        Product p1 = new Product();
        p1.setId(-1L);
        p1.setTitle("fork");
        p1.setPrice(5.0);
        p1.setDescription("Basic fork");

        Product p2 = new Product();
        p2.setId(-2L);
        p2.setTitle("knife");
        p2.setPrice(4.0);
        p2.setDescription("Basic knife");

        Product p3 = new Product();
        p3.setId(-3L);
        p3.setTitle("spoon");
        p3.setPrice(3.0);
        p3.setDescription("Basic spoon");

        List<Product> products = new ArrayList<Product>(){{
            add(p1);
            add(p2);
            add(p3);
        }};
        return products;
    }
}
