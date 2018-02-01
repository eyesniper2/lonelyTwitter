/*
 * Tweet.java
 *
 * 31/01/18 5:29 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents a tweet.
 *
 * @author eyesniper2
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {

    @Expose
    private String message;
    @Expose
    private Date date;
    @Expose
    private HashSet<Mood> moods;

    /**
     * Constructs a tweet object
     *
     * @param message tweets message
     */
    Tweet(String message) {
        moods = new HashSet<Mood>();
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Constructs a tweet object
     *
     * @param message tweets message
     * @param date tweets date
     */
    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * Get Date of Tweet
     * Returns the date of the tweet
     * @return date
     */
    public Date getDate()  {
        return this.date;
    }

    public String getMessage() {
        String message = this.message;
        for(Mood m: moods) {
            m.formatMessage(message);
        }
        return message;
    }

    /**
     * Set tweet message
     *
     * @param message tweets message
     * @throws TweetTooLongException thrown if tweet exceeds 140 chars
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    @Override
    public String toString(){
        return this.message;
    }

    /**
     * Set date for tweet
     * @param date The date to set for the tweet.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Add a mood to the tweet
     * @param mood mood to add
     */
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    /**
     * Remove a mood from the tweet
     * @param mood mood to remove
     */
    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    /**
     * Check to see if tweet is important
     * @return if the tweet is important
     */
    public abstract boolean isImportant();
}