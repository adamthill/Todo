package com.example.todo;

import android.content.Context;
import android.widget.Toast;

//import org.json.JSONObject;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

    //Will read and write the entire JSON list of lists each time
    public boolean saveListToFile(ArrayList<ListItem> items, Context context) {
        //save to disk
        String FILENAME = "todolist.js";

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

    public ArrayList<List> readListsFromFile() {
        ArrayList<List> lists = new ArrayList<List>();

//        try {
//            BufferedReader inputReader = new BufferedReader(new InputStreamReader(
//                    openFileInput(FILENAME)));
//            String inputString;
//            StringBuffer stringBuffer = new StringBuffer();
//            while ((inputString = inputReader.readLine()) != null) {
//                stringBuffer.append(inputString + "\n");
//            }
//            Toast.makeText(getApplicationContext(),
//                    stringBuffer.toString(),
//                    Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }

        return lists;
    }


}
