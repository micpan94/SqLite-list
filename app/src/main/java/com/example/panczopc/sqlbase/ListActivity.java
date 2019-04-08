package com.example.panczopc.sqlbase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabaseHelper = new DatabaseHelper(this);
        mListView = (ListView)findViewById(R.id.listView);

        populateListView();
    }

    private void populateListView(){

        Log.d(TAG,"populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listdata = new ArrayList<>();
        while (data.moveToNext()){
            listdata.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listdata);
        mListView.setAdapter(adapter);
    }

    private void tostmes(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}
