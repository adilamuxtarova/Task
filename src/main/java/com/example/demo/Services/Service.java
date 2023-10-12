package com.example.demo.Services;

import com.example.demo.Models.Product;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;

import java.util.List;

public interface Service {

    List<Response> getAll();

    Response getById(Integer id);

    Response add(Request request);

    Response update(Request request);

    void delete(Integer id);
}
