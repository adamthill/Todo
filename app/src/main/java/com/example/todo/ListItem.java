package com.example.todo;

/**
 * Created by adam on 5/19/15.
 */
public class ListItem {
    private String itemText;
    public String getItemText() {
        return itemText;
    }
    public void setItemText(String itemText) {
        this.itemText = itemText;
    }


    private Boolean isDone;
    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }


    public ListItem(String ItemText, Boolean IsDone) {
        setItemText(ItemText);
        setIsDone(IsDone);
    }
}
