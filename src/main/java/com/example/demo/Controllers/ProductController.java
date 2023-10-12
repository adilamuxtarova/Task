package com.example.demo.Controllers;
import com.example.demo.Services.Service;
import com.example.demo.dto.Request;
import com.example.demo.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/api/Products")
@RequiredArgsConstructor
public class ProductController
{
    public final Service service;

    @GetMapping
    public List<Response> getAllCustomers()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Response GetById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping
    public void AddProduct(@RequestBody Request request)
    {
        service.add(request);
    }
    @PutMapping
    public Response Update(Request request)
    {
        return service.update(request);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id)
    {
        service.delete(id);
    }
}
