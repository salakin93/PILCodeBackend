package com.example.PILcodeChallenge.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private Long id;
    private String product_name;
    private int stock;
    @Column(length = 65535)
    private String product_image;
}
