package com.example.jari.rssreader;

import java.util.ArrayList;

/**
 * Created by jari on 02/10/15.
 */
public class User {

    private static User instance = new User();

    private User(){}

    public static User getInstance(){
        return instance;
    }

    public ArrayList<RSSItem> feeds = new ArrayList<>(30);

    public void addFeeds(RSSItem rssItem){
        feeds.add(rssItem);
    }

    public ArrayList<RSSItem> getFeeds(){
        return feeds;
    }

    public String getLink(int position){
        return feeds.get(position).getLink();
    }

    public ArrayList<RSSItem> visited = new ArrayList<>();

    public ArrayList<RSSItem> getVisited(){
        return visited;
    }

    public String getImage(){
        return this.getImage();
    }

    public ArrayList<RSSItem> bookmarks = new ArrayList<>();

    public ArrayList<RSSItem> getBookmarks(){
        return bookmarks;
    }

    public void addBookmarks(RSSItem rssItem){
        bookmarks.add(rssItem);
    }

    public String getBookmarkLink(int position){
        return bookmarks.get(position).getLink();
    }
}
