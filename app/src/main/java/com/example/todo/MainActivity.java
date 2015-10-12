package com.example.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new ListItemFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.save_list) {
            DataProvider dp = DataProvider.getInstance();
            ListItemFragment fragment = (ListItemFragment)getSupportFragmentManager().findFragmentById(R.id.container);
            dp.saveListToFile(fragment.mListItems, getApplicationContext());

            //test code until we move this into DataProvider
            String FILENAME = "todolist.js";
            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                        openFileInput(FILENAME)));
                String inputString;
                StringBuffer stringBuffer = new StringBuffer();
                while ((inputString = inputReader.readLine()) != null) {
                    stringBuffer.append(inputString + "\n");
                }
                Toast.makeText(getApplicationContext(),
                        stringBuffer.toString(),
                        Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();

            }

            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
