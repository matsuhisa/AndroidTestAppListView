package com.example.matsuhisahironobu.androidtestapplistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // データーを用意する
        //String[] items = {"item 0", "item 1", "item 2"};

        // ArrayList
        List<String> items = new ArrayList<String>();
        for(int i = 0; i < 20; i++)
        {
            items.add("item " + i);
        }

        // Adapter を用意する
        // - context
        // - レイアウト（セル部分）
        // - データー

        // R.layout は自分で決めたレイアウト
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, items);
        // android.R.layout は、android がデフォルトで決めたレイアウト
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);

        // ListView
        final ListView myListView = (ListView) findViewById(R.id.MylistView);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MyActivity.this, Integer.toString(i) + "番目の要素です", Toast.LENGTH_SHORT).show();

                //String s = myListView.getItemAtPosition(i).toString();
                //Toast.makeText(MyActivity.this, s, Toast.LENGTH_SHORT).show();

                TextView tv = (TextView) view;
                tv.setText("Clicked!");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
