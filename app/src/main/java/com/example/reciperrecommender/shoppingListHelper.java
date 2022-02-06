package com.example.reciperrecommender;

public class shoppingListHelper {
    String shoplist_item;

    public shoppingListHelper() {
    }

    public shoppingListHelper(String shoplist_item) {
        this.shoplist_item = shoplist_item;
    }

    public String getShoplist_item() {
        return shoplist_item;
    }

    public void setShoplist_item(String shoplist_item) {
        this.shoplist_item = shoplist_item;
    }
}
