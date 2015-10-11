package com.example.jari.rssreader;

/**
 * Created by jari on 25/09/15.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class XMLHandler extends Activity {

    private String title = "title";
    private String link = "link";
    private String description = "description";
    private String pubDate = "pubDate";
    private long timeInMinutesSinceEpoch;
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    private Sources sources = new Sources();
    User user = User.getInstance();
    public volatile boolean parsingComplete = false;
    private Bitmap bitmap;
    private String image;


    public XMLHandler(String url) {

        this.urlString = url;
    }


    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;
        boolean insideItem = false;

        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.START_TAG) {
                    if (myParser.getName().equalsIgnoreCase("item")) {
                        insideItem = true;
                    }
                    else if (myParser.getName().equalsIgnoreCase("url")) {
                        insideItem = true;
                    }else if (myParser.getName().equalsIgnoreCase("title")) {
                        if (insideItem)
                            this.title = myParser.nextText();
                    } else if (myParser.getName().equalsIgnoreCase("link")) {
                        if (insideItem)
                            this.link = myParser.nextText() + "\n\n";
                    }else if (myParser.getName().equalsIgnoreCase("description")) {
                        if (insideItem)
                            this.description = myParser.nextText() + "\n";
                    }else if (myParser.getName().equalsIgnoreCase("pubdate")) {
                        if (insideItem)
                            this.pubDate = myParser.nextText() + "\n";
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z");
                            Date date = sdf.parse(this.pubDate);
                            long timeInMillisSinceEpoch = date.getTime();
                            this.timeInMinutesSinceEpoch = timeInMillisSinceEpoch / (60 * 1000);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else if (event == XmlPullParser.END_TAG && myParser.getName().equalsIgnoreCase("item")) {
                    RSSItem rss = new RSSItem(title, link, description, timeInMinutesSinceEpoch);
                    if (user.feeds.size() <= 30) {
                        user.addFeeds(rss);
                    }
                    insideItem = false;
                }

                event = myParser.next();
                sources.sources.iterator().next();
            }
            //allFeeds.addAll(getList());
            parsingComplete = true;
            System.out.println("Parsing complete");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fetchXML() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //con.setReadTimeout(1000); //time in milliseconds
                    //con.setConnectTimeout(1500);
                    con.setRequestMethod("GET");
                    con.setDoInput(true);

                    con.connect();
                    InputStream stream = con.getInputStream();

                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myParser = xmlFactoryObject.newPullParser();

                    myParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myParser.setInput(stream, null);

                    parseXMLAndStoreIt(myParser);
                    stream.close();

                } catch (Exception e) {

                }
            }
        });
        thread.start();
    }

    /*public void bitmap(){
        try {
            String urlStr = "http://www.profightdb.com/img/wrestlers/thumbs-600/4d54a6c767johncena.jpg";
            URL imageUrl = new URL(urlStr);
            ImageView i = (ImageView)findViewById(R.id.image1);
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
            i.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}

