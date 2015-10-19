package com.example.todo;

import android.content.Context;
import android.widget.Toast;

//import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by adam on 8/24/15.
 */
public class DataProvider {
    private static DataProvider instance = null;
    public static synchronized DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }
    private DataProvider() {
    }

    private Gson gson = new Gson();
    private String FILENAME = "todolist.js";


    //Will read and write the entire JSON list of lists each time
    public boolean saveListToFile(ArrayList<ListItem> items, Context context) {
        //save to disk

        String gsonData = gson.toJson(items);

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            fos.write(gsonData.getBytes());
            fos.close();
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<ListItem> readListsFromFile(Context context) {
        ArrayList<ListItem> items = new ArrayList<ListItem>();

        Type collectionType = new TypeToken<ArrayList<ListItem>>() {}.getType();

        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                    context.openFileInput(FILENAME)));
//            String inputString;
//            StringBuffer stringBuffer = new StringBuffer();
//            while ((inputString = inputReader.readLine()) != null) {
//                stringBuffer.append(inputString + "\n");
//            }
//            Toast.makeText(context,
//                    stringBuffer.toString(),
//                    Toast.LENGTH_LONG).show();
            items = gson.fromJson(inputReader, collectionType);

        } catch (IOException e) {
            e.printStackTrace();

        }

        return items;
    }


}
