package com.example.jari.rssreader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jari on 01/10/15.
 */
public class Sources {

    public ArrayList<String> sources = new ArrayList();
    public ArrayList<String> it = new ArrayList();
    public ArrayList<String> viihde = new ArrayList();
    public ArrayList<String> urheilu = new ArrayList();
    public ArrayList<String> talous = new ArrayList();
    public ArrayList<String> tuoreet = new ArrayList();


    public Sources() {


        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=viihde");
        sources.add("http://www.mtv.fi/api/feed/rss/viihde_uusimmat_100");
        sources.add("http://www.iltasanomat.fi/rss/viihde.xml");
        sources.add("http://www.iltasanomat.fi/rss/urheilu.xml");
        sources.add("http://www.mtv.fi/api/feed/rss/urheilu");
        sources.add("http://www.mtv.fi/api/feed/rss/uutiset_talous");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=talous");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=pelit");
        sources.add("http://www.mtv.fi/api/feed/rss/uutiset_it");
        sources.add("http://www.mtv.fi/api/feed/rss/uutiset_uusimmat");
        sources.add("http://yle.fi/uutiset/rss/uutiset.rss");

        it.add("http://www.mtv.fi/api/feed/rss/uutiset_it");
        it.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=pelit");

        viihde.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=viihde");
        viihde.add("http://www.mtv.fi/api/feed/rss/viihde_uusimmat_100");
        viihde.add("http://www.iltasanomat.fi/rss/viihde.xml");

        urheilu.add("http://www.iltasanomat.fi/rss/urheilu.xml");
        urheilu.add("http://www.mtv.fi/api/feed/rss/urheilu");

        talous.add("http://www.mtv.fi/api/feed/rss/uutiset_talous");
        talous.add("http://yle.fi/uutiset/rss/uutiset.rss?osasto=talous");

        tuoreet.add("http://www.mtv.fi/api/feed/rss/uutiset_uusimmat");
        tuoreet.add("http://yle.fi/uutiset/rss/uutiset.rss");


    }



}
