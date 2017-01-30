package com.chris.dao;

import com.chris.domain.Item;

public interface ItemDao {

    Item getItem(int id);

    Item getItemByName(String name);

    void insertItem(Item item);
}
