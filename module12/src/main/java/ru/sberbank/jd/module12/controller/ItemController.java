package ru.sberbank.jd.module12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.module12.entity.Item;
import ru.sberbank.jd.module12.controller.input.ItemInput;
import ru.sberbank.jd.module12.repository.ItemRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@RequestBody ItemInput input) {
        return itemRepository.save(Item.of(input));
    }

    @GetMapping
    public List<Item> getItem(@RequestParam(name = "name") String itemName) {
        return itemRepository.findByName(itemName);
    }
}
