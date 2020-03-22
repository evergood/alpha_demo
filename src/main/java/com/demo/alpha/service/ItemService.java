package com.demo.alpha.service;

import com.demo.alpha.domen.Item;

public interface ItemService {
    Iterable<Item> saveAll(Iterable<Item> items);

    Item save(Item item);
}
