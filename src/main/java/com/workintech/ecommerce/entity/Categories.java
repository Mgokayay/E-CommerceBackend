package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories",schema = "fsweb")
public class Categories {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "gender")
    private String gender;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "categories",cascade = {CascadeType.ALL})
    private List<Product> products;

    //TODO null pointer checki yap!!






}
