package com.myproducts.model;

public class Product {

    public Product(String name, boolean hasDiscount){
        this.name = name;
        this.hasDiscount = hasDiscount;

    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    private boolean hasDiscount;


}
