package com.example.jari.rssreader;

/**
 * Created by jari on 25/09/15.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class second extends Activity {

    private XMLHandler obj;
    ListView items;

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, obj.getList());

        listView.setAdapter(adapter);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        TextView tv = (TextView) findViewById(R.id.rss_feed);
        tv.setText("Selection: " + listView[position]);
    }*/
}
