package com.demo.alpha.util;

import com.demo.alpha.domen.Box;
import com.demo.alpha.domen.Storage;
import com.demo.alpha.service.BoxService;
import com.demo.alpha.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        //log.debug(storage.getBoxes().toString());
        //log.debug(storage.getBoxes().get(0).getItems().toString());
        //log.debug(storage.getItems().toString());
        boxService.save(storage.getBoxes().get(0));
        //boxService.save(storage.getBoxes().get(0));
        /*Iterable<Item> items = storage.getItems();
        for (Item item : items) {
            itemService.save(item);

        }*/
    }
}
