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
@Table(name = "user",schema = "fsweb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @Column(name = "role_id")
//    private long roleId;

//    @Column(name = "store_id")
//    private long storeId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "role_id")
    Role role;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Card> cardList;

    public void addCard(Card card){
        if(cardList==null){
            cardList=new ArrayList<>();
        }
        cardList.add(card);
    }

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Address> addressList;

    public void addAddress(Address address){
        if(addressList==null){
            addressList=new ArrayList<>();
        }
        addressList.add(address);
    }
}
