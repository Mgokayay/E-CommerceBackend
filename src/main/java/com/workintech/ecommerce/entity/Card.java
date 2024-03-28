package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card",schema = "fsweb")
public class Card {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;


    @Column(name = "card_no")
    private long cardNo;

    @Column(name = "card_expire_month")
    private long cardExpireMonth;

    @Column(name = "card_expire_year")
    private long cardExpireYear;

    @Column(name = "card_ccv")
    private long carCcv;

    @Column(name = "card_name")
    private String cardName;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    User user;

}
