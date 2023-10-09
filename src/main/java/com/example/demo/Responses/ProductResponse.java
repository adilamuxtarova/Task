package com.example.demo.Responses;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProductResponse {
    public String Name;
    public  Integer Price;
    public Date CreatedAt;
}
