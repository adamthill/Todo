package com.example.todo;

import java.util.ArrayList;

/**
 * Created by adam on 4/6/15.
 */
public class MockDataProvider {
    private static MockDataProvider instance = null;

    ArrayList<ListItem> items = new ArrayList<ListItem>();

    private MockDataProvider() {
        items.add(new ListItem("item1", false));
        items.add(new ListItem("item2", true));
        items.add(new ListItem("item3", false));
    }

    public static synchronized MockDataProvider getInstance() {
        if (instance == null) {
            instance = new MockDataProvider();
        }
       return instance;
    }

    public ArrayList<ListItem> getItems() {
        return items;
    }

    public ArrayList<String> getItemNames() {
        ArrayList<String> itemNames = new ArrayList<String>();
        for (ListItem item : items) {
            itemNames.add(item.getItemText());
        }
        return itemNames;
    }

}
