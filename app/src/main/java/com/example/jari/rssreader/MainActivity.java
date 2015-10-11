package com.example.jari.rssreader;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    XMLHandler obj;
    Sources sources = new Sources();
    User user = User.getInstance();
    RSSItem bookmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // UrlImageView urlImg = new UrlImageView(this).setImageURL("http://abc.png");
        setContentView(R.layout.activity_main);

        //urlImg.setImageURL("http://abc2.png");
        //((UrlImageView)findViewById(R.id.thumbnail)).setImageURL("http://foo.bar.png");



        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.sources.size()) {
            obj = new XMLHandler(sources.sources.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_all, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                bookmark = user.feeds.get(position);
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
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
       recreate();
    }

    public void sports(View view){
        user.feeds.clear();
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.urheilu.size()) {
            obj = new XMLHandler(sources.urheilu.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_sports, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void it(View view){
        user.feeds.clear();
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.it.size()) {
            obj = new XMLHandler(sources.it.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_it, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void viihde(View view){
        user.feeds.clear();
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.viihde.size()) {
            obj = new XMLHandler(sources.viihde.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_viihde, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void news(View view){
        user.feeds.clear();
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.tuoreet.size()) {
            obj = new XMLHandler(sources.tuoreet.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_news, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void finance(View view){
        user.feeds.clear();
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.talous.size()) {
            obj = new XMLHandler(sources.talous.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_finance, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                user.visited.add(user.feeds.get(position));
                user.feeds.get(position).changeTitle();
                String uri = user.getLink(position);
                v.setSelected(true);


                /**parent.getChildAt(position).setBackgroundColor(
                 Color.parseColor("#A9BCF5"));

                 if (save != -1 && save != position) {
                 parent.getChildAt(save).setBackgroundColor(
                 Color.parseColor("#d6e6ff"));
                 }

                 save = position;
                 **/

                Bundle bundle = new Bundle();
                bundle.putString("content", uri);
                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked", "pos: " + pos);

                bookmark = user.feeds.get(pos);
                user.addBookmarks(bookmark);
                System.out.println(user.getBookmarks());
                Toast.makeText(getApplicationContext(), "Saved to bookmarks.",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    public void like(){

        ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                R.layout.listitem_news, R.id.textView1, user.getFeeds());

        listView.setAdapter(adapter);

        sortByDate();
        //obj.bitmap();
        //ImageView imageView = (ImageView) findViewById(R.id.image1);
        //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");





    int save = -1;
    listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

        }
        });

    }

    public void bookmark(View view){
        listView = (ListView) findViewById(R.id.feed);

        int i = 0;

        while (i < sources.talous.size()) {
            obj = new XMLHandler(sources.talous.get(i));
            obj.fetchXML();
            i++;


            while (!obj.parsingComplete) ;

            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                    R.layout.listitem_all, R.id.textView1, user.getFeeds());

            listView.setAdapter(adapter);

            sortByDate();
            //obj.bitmap();
            //ImageView imageView = (ImageView) findViewById(R.id.image1);
            //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


        }


        int save = -1;
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

                user.bookmarks.add(user.feeds.get(position));
                System.out.println("asdasd " + user.bookmarks);

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

        switch(id){
            case R.id.kirjanmerkit:
                listView = (ListView) findViewById(R.id.feed);

                    ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this,
                            R.layout.listitem_bookmarks, R.id.textView1, user.getBookmarks());

                    listView.setAdapter(adapter);

                    sortByDate();
                    //obj.bitmap();
                    //ImageView imageView = (ImageView) findViewById(R.id.image1);
                    //new ImageDownloader(imageView).execute("http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg");


                }


                int save = -1;
                listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                        String uri = user.getBookmarkLink(position);
                        v.setSelected(true);


                        /**parent.getChildAt(position).setBackgroundColor(
                         Color.parseColor("#A9BCF5"));

                         if (save != -1 && save != position) {
                         parent.getChildAt(save).setBackgroundColor(
                         Color.parseColor("#d6e6ff"));
                         }

                         save = position;
                         **/

                        Bundle bundle = new Bundle();
                        bundle.putString("content", uri);
                        Intent intent = new Intent(MainActivity.this, Second.class);
                        intent.putExtras(bundle);
                        startActivity(intent);



                    }
                });



        //noinspection SimplifiableIfStatement
        if (id == R.id.munakoiso) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle(R.string.quitDialog); alert.setMessage(R.string.quitMessage);

            alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    MainActivity.this.finish();
                }
            });
            alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                }
            });
            alert.show();

        }  return true; }
}

