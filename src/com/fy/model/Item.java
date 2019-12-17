package com.fy.model;

public class Item {
    private int id;
    private String name;
    private String destr;
    private int num;

    public Item() {

    }

    public Item(String name, String destr, int num) {
        this.name = name;
        this.destr = destr;
        this.num = num;
    }

    public Item(int id, String name, String destr, int num) {
        this.id = id;
        this.name = name;
        this.destr = destr;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestr() {
        return destr;
    }

    public void setDestr(String destr) {
        this.destr = destr;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
