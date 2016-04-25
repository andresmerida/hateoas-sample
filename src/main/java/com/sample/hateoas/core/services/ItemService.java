package com.sample.hateoas.core.services;

import com.sample.hateoas.core.entities.Item;

/**
 * Created by andresmerida on 4/4/2016.
 */

// TODO should be deleted this services inteface
public interface ItemService {
    Item updateItem(Long id, Item item);
}
