package com.example.recyclerviewwithcontextmenu;

public class Fruit
{

    private int fruit_image_id;
    private String fruit_name;

    public Fruit(int fruit_image_id, String fruit_name) {
        this.fruit_image_id = fruit_image_id;
        this.fruit_name = fruit_name;
    }

    public int getFruit_image_id() {
        return fruit_image_id;
    }

    public String getFruit_name() {
        return fruit_name;
    }
}
