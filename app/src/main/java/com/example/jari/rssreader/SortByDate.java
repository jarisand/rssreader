package com.example.jari.rssreader;

import java.util.Comparator;

/**
 * Created by jari on 01/10/15.
 */
public class SortByDate implements Comparator<RSSItem> {

    @Override
    public int compare(RSSItem rss1, RSSItem rss2) {
        if(rss1.getDate() < rss2.getDate()){
            return 1;
        } else {
            return -1;
        }
    }
}
