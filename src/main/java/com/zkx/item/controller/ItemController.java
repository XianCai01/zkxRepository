package com.zkx.item.controller;

import com.zkx.item.entity.Item;
import com.zkx.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id){
        System.out.println("service port: "+port);
        return this.itemService.queryItemById(id);
    }
}
