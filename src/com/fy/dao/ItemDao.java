package com.fy.dao;

import com.fy.model.Item;

import java.util.List;

public interface ItemDao {

    public List<Item> findItemAll();

    public int addItem(Item item);

    public int deleteItem(int id);

    public Item getItem(int id);

    public int updateItem(Item item);
}
