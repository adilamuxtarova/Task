package com.example.demo.Services;


import com.example.demo.Models.Product;
import com.example.demo.Repository.Repository;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImplementation implements  Service
{

    private final Repository repository;
    private final ModelMapper mapper;


    @Override
    public List<Response> getAll()
    {
        var products = repository.getAll();

        List<Response> responses = products.stream()
                .map(product -> mapper.map(product,Response.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public Response getById(Integer id) {

        var product = repository.getProductById(id);

        return mapper.map(product,Response.class);
    }

    @Override
    public Response add(Request request)
    {
        var convertedProduct = mapper.map(request,Product.class);

        var newProduct = repository.addProduct(convertedProduct);

        return mapper.map(newProduct.getClass(),Response.class);
    }
    @Override
    public Response update( Request request)
    {
        var newProduct = mapper.map(request,Product.class);
        Product product = repository.updateProduct(newProduct);
        var result = mapper.map(product,Response.class);
        return result;
    }
    @Override
    public void delete(Integer id)
    {
        repository.delete(id);
    }
}
