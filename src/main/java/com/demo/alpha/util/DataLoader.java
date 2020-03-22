package com.demo.alpha.util;

import com.demo.alpha.domen.Box;
import com.demo.alpha.domen.Item;
import com.demo.alpha.domen.Storage;
import com.demo.alpha.service.BoxService;
import com.demo.alpha.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader {

    private BoxService boxService;
    private ItemService itemService;

    @Autowired
    public DataLoader(Parser parser, BoxService boxService, ItemService itemService) {
        this.boxService = boxService;
        this.itemService = itemService;
    }

    @EventListener
    public void run(ContextRefreshedEvent event) throws Exception {
        Storage storage = Parser.parseStorage();
        Iterable<Box> boxes = storage.getBoxes();
        Iterable<Item> items = storage.getItems();
        boxService.saveAll(boxes);
        itemService.saveAll(items);
    }
}
