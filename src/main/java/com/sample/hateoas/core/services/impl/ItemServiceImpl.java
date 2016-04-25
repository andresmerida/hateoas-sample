package com.sample.hateoas.core.services.impl;

import com.sample.hateoas.core.entities.Item;
import com.sample.hateoas.core.repositories.ItemRepository;
import com.sample.hateoas.core.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andresmerida on 4/4/2016.
 */

// TODO should be deleted this services imp
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public Item updateItem(Long id, Item item) {
        Item itemModified = itemRepository.findOne(id);
        itemModified.setName(item.getName());
        return itemRepository.save(itemModified);
    }
}
