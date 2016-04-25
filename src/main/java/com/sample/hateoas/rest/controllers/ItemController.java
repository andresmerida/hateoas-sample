package com.sample.hateoas.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sample.hateoas.core.entities.Item;
import com.sample.hateoas.core.repositories.ItemRepository;
import com.sample.hateoas.core.services.ItemService;

import java.util.List;

/**
 * Created by andresmerida on 4/4/2016.
 */

// TODO should be deleted this controller
@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Item change(@RequestBody Item item) {
        return itemService.updateItem(item.getId(), item);
    }
}
