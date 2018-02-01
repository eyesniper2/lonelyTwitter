/*
 * NormalTweet.java
 *
 * 31/01/18 6:06 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Constructs a important tweet
 *
 * @author eyesniper2
 * @see Tweet
 */
public class NormalTweet extends Tweet {

    /**
     * Normal Tweet constructor
     * @param message message of tweet
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Normal Tweet constructor
     * @param message message of tweet
     * @param date date of tweet
     */
    public NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Check to see if a tweet is important
     *
     * @return if the tweet is important
     */
    @Override
    public boolean isImportant(){
        return false;
    }
}
