package com.demo.alpha.controller;

import com.demo.alpha.domen.Item;
import com.demo.alpha.service.impl.ItemServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StorageController {

    @Autowired
    ItemServiceImpl itemService;

    @GetMapping("/info")
    @ResponseBody
    public JSONArray getInfo(@RequestBody JSONObject input) {
        Integer boxId = (Integer) input.get("box");
        String color = (String) input.get("color");
        JSONArray responce = new JSONArray();
        for (Item item : itemService.findByBoxIsAndColor(boxId, color)) {
            responce.add(item.getId());
        }
        return responce;
    }
}
