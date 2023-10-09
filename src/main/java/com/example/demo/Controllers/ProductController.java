package com.example.demo.Controllers;

import com.example.demo.Configs.ModelMapperConfig;
import com.example.demo.DTOs.ProductDto;
import com.example.demo.Models.Product;
import com.example.demo.Responses.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private final ModelMapperConfig modelMapper;
    public ProductController(ModelMapperConfig modelMapper) {
        this.modelMapper = modelMapper;
    }

    private final Map<Long,Product> productHashMap = new HashMap<>();
    private int idCounter = 1;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductDto dto) {

        var product = new Product();

            product.Id = idCounter++;
        product = modelMapper.modelMapper().map(dto,product.getClass());

        product.CreatedAt = new Date();

        productHashMap.put(Long.valueOf(product.Id), product);

        ProductResponse response = new ProductResponse();
        response.CreatedAt = product.CreatedAt;
        response.Price = product.Price;
        response.Name = product.Name;
        return response;
    }

    @GetMapping
    public  Product GetProductById(@RequestBody Integer Id)
    {
      var selectedProduct = productHashMap.get(Id);
      return selectedProduct;
    }

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts() {

        Collection<Product> products = productHashMap.values();

        List<Product> productList = new ArrayList<>(products);

        List<ProductResponse> responseList = new ArrayList<>();

        for (Product product : productList) {
            ProductResponse response = new ProductResponse();
            response.Name = product.Name;
            response.Price = product.Price;
            response.CreatedAt = product.CreatedAt;

            responseList.add(response);
        }
        return responseList ;
    }


    @PutMapping("/{productId}")
    public ProductResponse updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductDto updatedProductDto) {

        Product existingProduct = productHashMap.get(productId);

        existingProduct.Name = updatedProductDto.getName();
        existingProduct.Price = updatedProductDto.getPrice();

        ProductResponse response = new ProductResponse();

        response.Name = existingProduct.Name;
        response.Price = existingProduct.Price;
        response.CreatedAt = new Date();


        return response;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId)
    {
        productHashMap.remove(productId);

    }

}
