package com.example.reciperrecommender;

import java.util.List;

public class shoppingListHelper {
    String shoplist_item;
    List<String> ShoppingList;

    public shoppingListHelper() {
    }

    public shoppingListHelper(String shoplist_item) {
        this.shoplist_item = shoplist_item;
        this.ShoppingList.add(shoplist_item);
    }

    public String getShoplist_item() {
        return shoplist_item;
    }

    public void setShoplist_item(String shoplist_item) {
        this.shoplist_item = shoplist_item;
    }

    public List<String> getShoppingList() {
        return ShoppingList;
    }

    public void setShoppingList(List<String> shoppingList) {
        ShoppingList = shoppingList;
    }
}
