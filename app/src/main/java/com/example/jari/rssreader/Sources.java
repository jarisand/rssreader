package com.example.jari.rssreader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jari on 01/10/15.
 */
public class Sources {

    public ArrayList<String> sources = new ArrayList();
    public Iterator iterator = sources.iterator();

    public Sources() {

        sources.add("http://www.iltasanomat.fi/rss/tuoreimmat.xml");
        sources.add("http://www.hs.fi/rss/?osastot=tekniikka");
        //feeds.add("http://yle.fi/uutiset/rss/paauutiset.rss");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=politiikka");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=kulttuuri");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=viihde");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=luonto");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=tiede");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=terveys");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=media");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=ilmasto");
    }

    public int getSize(){
        return sources.size();
    }

    public boolean getNext(){
        return iterator.hasNext();
    }


}
