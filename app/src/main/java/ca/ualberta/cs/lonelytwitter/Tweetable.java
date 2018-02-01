/*
 * Tweetable.java
 *
 * 31/01/18 5:49 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * The interface for a Tweetable object
 *
 * @author eyesniper2
 */
public interface Tweetable {

    /**
     * Get the message of a tweet
     *
     * @return message of tweet
     */
    String getMessage();

    /**
     * Set the message of a tweet
     *
     * @param message message of tweet
     * @throws TweetTooLongException thrown if the tweet is longer then 140 chars
     */
    void setMessage(String message) throws TweetTooLongException;

    /**
     * Get the date of a tweet
     *
     * @return the date of the tweet
     */
    Date getDate();

    /**
     * Set the date of a tweet
     *
     * @param date date of the tweet
     */
    void setDate(Date date);
}
