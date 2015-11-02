package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adam on 5/19/15.
 */
public class ListItemAdapter extends ArrayAdapter<ListItem> {
    private ArrayList<ListItem> mListItems;
    public ArrayList<ListItem> getListItems() {
        return mListItems;
    }

    private Context mContext;

    public ListItemAdapter(Context context, int textViewResourceId, ArrayList<ListItem> listItems) {
        super(context, textViewResourceId, listItems);
        mContext = context;
        mListItems = new ArrayList<ListItem>();
        mListItems.addAll(listItems);
    }


    private class ViewHolder {
        EditText item;
        CheckBox checked;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater viewInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = viewInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.item = (EditText)convertView.findViewById(R.id.item_name);
            holder.checked = (CheckBox)convertView.findViewById(R.id.item_checked);
            convertView.setTag(holder);

            holder.checked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    ListItem listItem = (ListItem) cb.getTag();
                    Toast.makeText(mContext.getApplicationContext(),
                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_LONG).show();
                    listItem.setIsDone(cb.isChecked());

                }
            });
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        ListItem listItem = getListItems().get(position);
        holder.item.setText(listItem.getItemText());
        holder.checked.setChecked(listItem.getIsDone());
        //holder.checked.setText(listItem.getItemText());
        holder.checked.setTag(listItem);

        return convertView;
    }

}
