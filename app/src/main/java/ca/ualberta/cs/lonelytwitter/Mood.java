/*
 * Mood.java
 *
 * 31/01/18 6:03 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Represents a mood
 *
 * @author eyesniper2
 * @see AngryMood
 * @see HappyMood
 * @see SadMood
 */
public abstract class Mood {

    private Date date;

    /**
     *
     */
    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Constructs a mood
     *
     * @param date date of mood
     */
    Mood(Date date) {
        this.date = date;
    }

    /**
     * Get the date of the mood
     * @return date of mood
     */
    public Date getDate(){
        return date;
    }

    /**
     * Set the date of the mood
     * @param date date of mood
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Format the message with a mood
     * @param message message to format
     * @return the formatted message
     */
    abstract String formatMessage(String message);
 }
