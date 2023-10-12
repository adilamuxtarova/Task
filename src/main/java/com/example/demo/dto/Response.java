package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Response {
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;
}