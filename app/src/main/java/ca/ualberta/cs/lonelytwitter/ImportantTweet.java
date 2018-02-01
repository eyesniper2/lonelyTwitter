/*
 * ImportantTweet.java
 *
 * 31/01/18 6:07 PM
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
public class ImportantTweet extends Tweet {

    /**
     * Important Tweet constructor
     *
     * @param message The tweet message.
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Important Tweet constructor
     *
     * @param message The tweet message.
     * @param date Date of tweet.
     */
    public ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Check to see if a tweet is important
     *
     * @return if the tweet is important
     */
    @Override
    public boolean isImportant(){
        return true;
    }

}