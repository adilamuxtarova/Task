package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
public class Product {

        @Id
    public Integer Id;
    public String  Name;
    public Integer Price;
    public Date CreatedAt;
}
