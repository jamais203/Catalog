package com.nexio.catalog.service;

import com.nexio.catalog.model.Product;
import com.nexio.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Retrieve all the products
     * @return list of products
     */
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        Iterator<Product> iterator = productRepository.findAll().iterator();
        while(iterator.hasNext()){
            products.add(iterator.next());
        }
        return products;
    }

    /**
     * Get product by id
     * @param id
     * @return a single product
     */
    public Product getProductById(long id){
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }
}
