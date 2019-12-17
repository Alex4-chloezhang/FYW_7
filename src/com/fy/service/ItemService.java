package com.fy.service;

import com.fy.model.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findItemAll();

    public int addItem(Item item);

    public int deleteItem(int id);

    public Item getItem(int id);

    public int updateItem(Item item);
}
