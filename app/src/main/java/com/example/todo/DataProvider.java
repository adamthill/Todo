package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import java.util.ArrayList;

/**
 * Created by adam on 3/30/15.
 */




public class DataProvider extends android.app.IntentService {

    ArrayList<ListItem> items = new ArrayList<ListItem>();

    public DataProvider() {
        super("DataProviderService");
    }


    @Override
    public void onCreate() {
        super.onCreate();

        items.add(new ListItem("item1", false));
        items.add(new ListItem("item2", true));
        items.add(new ListItem("item3", false));
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        String url = intent.getStringExtra("url");

        Bundle bundle = new Bundle();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        items = null;
    }
}


class ListItem {
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


