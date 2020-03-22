package com.demo.alpha.service;

import com.demo.alpha.domen.Item;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemService {
    Iterable<Item> saveAll(Iterable<Item> items);

    public List<Integer> findByBoxIsAndColor(Integer id,String color);
}
