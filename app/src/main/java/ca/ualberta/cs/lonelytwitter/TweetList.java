/*
 * TweetList.java
 *
 * 14/02/18 5:26 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException("Duplicate tweet");
        }
        tweets.add(tweet);
    }

    public ArrayList<Tweet> getTweets() {
        // Make local copy of array list
        ArrayList<Tweet> tweetList = new ArrayList<Tweet>(tweets);
        // Ref: https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        Collections.sort(tweetList, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return tweetList;
    }

    public int getCount() {
        return tweets.size();
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }


}
