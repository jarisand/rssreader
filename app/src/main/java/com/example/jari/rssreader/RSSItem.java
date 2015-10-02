package com.example.jari.rssreader;

/**
 * Created by jari on 25/09/15.
 */
public class RSSItem {

    private String title;
    private String link;
    private String description;
    private long pubDate;

    public RSSItem(String title, String link, String description, long pubDate){
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;

    }

    public RSSItem(String link){

        this.link = link;
    }

    public RSSItem(){

    }

    @Override
    public String toString(){
        //return link;
        return this.title;
    }

    public String getLink(){

        return this.link;
    }

    public Long getDate(){
        return this.pubDate;
    }


}
