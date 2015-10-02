package com.example.jari.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends Activity {

    ListView listView;
    XMLHandler obj;
    Sources sources = new Sources();
    User user = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while(i<sources.sources.size()) {
            obj = new XMLHandler(sources.sources.get(i));
            obj.fetchXML();
            i++;

            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
        }

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                String uri = user.getLink(position);
                Uri webpage = Uri.parse(uri);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(webIntent);

            }
        });
    }


    public void sortByDate() {
        Collections.sort(user.feeds, new Comparator<RSSItem>() {
            @Override
            public int compare(RSSItem rss1, RSSItem rss2) {
                if (rss1.getDate() < rss2.getDate())
                    return 1;
                if (rss1.getDate() > rss2.getDate())
                    return -1;
                return 0;
            }
        });
    }

    public void refresh(View view) {
        user.feeds.clear();
        int i = 0;

        while(i<sources.sources.size()) {
            obj = new XMLHandler(sources.sources.get(i));
            obj.fetchXML();
            i++;

            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
        }

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                String uri = user.getLink(position);
                Uri webpage = Uri.parse(uri);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(webIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds listView to the action bar if it is present.
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
        return super.onOptionsItemSelected(item);
    }


}

