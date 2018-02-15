/*
 * TweetListTest.java
 *
 * 14/02/18 5:20 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;


import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() throws Exception {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("adding a tweet");
        tweets.addTweet(tweet1);
        assertTrue(tweets.hasTweet(tweet1));
        // Ref: https://stackoverflow.com/questions/13252572/java-exception-testing-with-junit-3
        try{
            tweets.addTweet(tweet1);
        }
        catch ( IllegalArgumentException e ){
            assertEquals( "Duplicate tweet", e.getMessage() );
        }
    }

    public void testHasTweet() throws Exception {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("adding a tweet");

        assertFalse(tweets.hasTweet(tweet1));

        tweets.addTweet(tweet1);

        assertTrue(tweets.hasTweet(tweet1));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("adding a tweet");

        tweets.addTweet(tweet1);

        Tweet getTweet = tweets.getTweet(0);
        assertEquals(getTweet.getDate(), tweet1.getDate());

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("adding a tweet");

        tweets.addTweet(tweet1);
        tweets.delete(tweet1);
        assertFalse(tweets.hasTweet(tweet1));
    }

    public void testGetTweets() throws Exception {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("adding a tweet");
        Tweet tweet2 = new NormalTweet("adding a tweet2");
        Tweet tweet3 = new NormalTweet("adding a tweet3");

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);

        ArrayList<Tweet> sorted = tweets.getTweets();

        assertTrue(sorted.get(0).equals(tweet1));
        assertTrue(sorted.get(1).equals(tweet2));
        assertTrue(sorted.get(2).equals(tweet3));

    }

    public void testGetCount(){
        TweetList tweets = new TweetList();

        assertTrue(tweets.getCount() == 0);

        Tweet tweet1 = new NormalTweet("adding a tweet");
        Tweet tweet2 = new NormalTweet("adding a tweet2");
        Tweet tweet3 = new NormalTweet("adding a tweet3");

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);

        assertTrue(tweets.getCount() == 3);
    }


}
