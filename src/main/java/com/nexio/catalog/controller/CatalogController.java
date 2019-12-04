package com.nexio.catalog.controller;

import com.nexio.catalog.Utils.CustomMessageType;
import com.nexio.catalog.error.CustomErrorType;
import com.nexio.catalog.model.Product;
import com.nexio.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CatalogController {

    @Autowired
    ProductService service;

    Set<Product> productsCart = new HashSet<>();

    /**
     *
     * @return the list of all products
     */
    @RequestMapping("/products")
    public List<Product> products(){
       return service.getProducts() ;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        Product product = service.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(new CustomErrorType("The product with id " + id + " was not found, please try another one."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity <Product> (product, HttpStatus.OK);
    }

    /**
     * Add a product to user's cart
     * @param id
     * @return an accept or error message to the end user
     */
    @GetMapping("/add/{id}")
    public ResponseEntity<?> addToCart(@PathVariable Long id){
        Product product = service.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(new CustomErrorType("The product with id " + id + " was not found, please try another one."),
                    HttpStatus.NOT_FOUND);
        }
        if(productsCart.contains(product)){
            return new ResponseEntity<>(new CustomMessageType("The product with id " + id + " is already in your list"),
                    HttpStatus.OK);
        }
        productsCart.add(product);
        return new ResponseEntity<>(new CustomMessageType("The product with id " + id + " was successfully added to your cart"),
                HttpStatus.OK);
    }

    /**
     *
     * @return the cart to the user containing his items
     */
    @GetMapping("/cart")
    public List<Product> getCart(){
        List<Product> cart = new ArrayList<>(productsCart);
        Collections.sort(cart, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getId() < o2.getId()){
                    return -1;
                }
                if(o1.getId() > o2.getId()){
                    return 1;
                }
                return 0;
            }
        });
        return cart;
    }

    /**
     * Remove a product from the user's cart
     * @param id
     * @@return an accept or error message to the end user
     */
    @GetMapping("remove/{id}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable Long id){
        Product product = service.getProductById(id);
        if(product == null){
            return new ResponseEntity<>(new CustomErrorType("The product with id " + id + " was not found, please try another one."),
                    HttpStatus.NOT_FOUND);
        }
        if(!productsCart.contains(product)){
            return new ResponseEntity<>(new CustomMessageType("The product with id " + id + " is not in your cart"),
                    HttpStatus.OK);
        }
        productsCart.remove(product);
        return new ResponseEntity<>(new CustomMessageType("The product with id " + id + " was successfully removed from your cart"),
                HttpStatus.OK);
    }
}
