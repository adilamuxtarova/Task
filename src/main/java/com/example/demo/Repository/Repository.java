package com.example.demo.Repository;


import com.example.demo.Models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository
{
        private HashMap<Integer, Product> productHashMap = new HashMap<>();

        public Product getProductById(Integer id) {
            return productHashMap.get(id);
        }

        public List<Product> getAll() {

            return new ArrayList<>(productHashMap.values());
        }

        public Product addProduct(Product product) {

            return productHashMap.put(product.getId(), product);

        }

        public Product updateProduct(Product newProduct) {

            return productHashMap.put(newProduct.getId() , newProduct);
        }

        public Product delete(Integer id) {

            return productHashMap.remove(id);
        }



}
