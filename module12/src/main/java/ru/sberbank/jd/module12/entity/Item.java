package ru.sberbank.jd.module12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sberbank.jd.module12.controller.input.ItemInput;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String article;

    private String name;

    @ManyToOne
    private Order order;

    public static Item of(ItemInput input) {
        var item = new Item();
        item.setArticle(input.getArticle());
        item.setName(input.getName());
        return item;
    }
}
