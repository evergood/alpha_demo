package com.demo.alpha.service.impl;

import com.demo.alpha.domen.Item;
import com.demo.alpha.repository.ItemRepository;
import com.demo.alpha.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> saveAll(Iterable<Item> items) {
        return itemRepository.saveAll(items);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}