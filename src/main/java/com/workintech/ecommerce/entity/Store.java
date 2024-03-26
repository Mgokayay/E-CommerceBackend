package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store",schema = "fsweb")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private long phone;

    @Column(name = "tax_no")
    private long taxNo;

    @Column(name = "bank_account")
    private long bankAccount;

    @Column(name = "user_id")
    private long userId;

    @OneToMany(mappedBy = "store" ,cascade = {CascadeType.ALL})
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = {CascadeType.ALL})
    private List<User> users;

    public void addUser(User user){
        if(users == null){
            users=new ArrayList<>();
        }
          users.add(user);
    }

    public void addProduct(Product product){
        if(products == null){
            products=new ArrayList<>();
        }
        products.add(product);
    }
}
