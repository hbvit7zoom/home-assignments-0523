package ru.sberbank.jd.module12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CLIENT_ORDER")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Item> items;

}
