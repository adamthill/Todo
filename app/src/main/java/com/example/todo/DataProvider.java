package com.example.todo;

import android.widget.Toast;

//import org.json.JSONObject;

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

    private ArrayList<List> lists = new ArrayList<List>();

//    private Gson gson = new Gson();


    //Will read and write the entire JSON list of lists each time
    public boolean saveListToFile() {
        //save to disk
        String FILENAME = "todolist.js";

        String string = "{title: ‘Marvel Heroes’, items: [{itemText: 'Hulk', isDone: false}]}";

        FileOutputStream fos = null;
        try {
//            fos = openFileOutput(FILENAME, getApplicationContext().MODE_WORLD_WRITEABLE);
            fos.write(string.getBytes());
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
