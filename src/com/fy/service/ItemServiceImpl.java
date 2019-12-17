package com.fy.service;

import com.fy.dao.ItemDaoImpl;
import com.fy.model.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    ItemDaoImpl idi = new ItemDaoImpl();

    @Override
    public List<Item> findItemAll() {

        return idi.findItemAll();
    }

    @Override
    public int addItem(Item item) {

        return idi.addItem(item);
    }

    @Override
    public int deleteItem(int id) {

        return idi.deleteItem(id);
    }

    @Override
    public Item getItem(int id) {

        return idi.getItem(id);
    }

    @Override
    public int updateItem(Item item) {

        return idi.updateItem(item);
    }
}
