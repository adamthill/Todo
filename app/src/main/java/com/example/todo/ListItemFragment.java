package com.example.todo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ListItemFragment extends ListFragment {

    ArrayList<ListItem> mListItems;
    private ListItemAdapter mListItemAdapter;

    public ListItemFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DataProvider dp = DataProvider.getInstance();
        mListItems = dp.readListsFromFile(getActivity().getApplicationContext());

        mListItemAdapter = new ListItemAdapter(getActivity(), R.layout.list_item, mListItems);
        setListAdapter(getListItemAdapter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        return rootView;
    }

    public ListItemAdapter getListItemAdapter() {
        return mListItemAdapter;
    }
}
