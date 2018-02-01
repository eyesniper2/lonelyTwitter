/*
 * HappyMood.java
 *
 * 31/01/18 6:07 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Represents a Happy Mood object.
 *
 * @author eyesniper2
 * @see Mood
 */
public class HappyMood extends Mood  {

    /**
     * Format the message of the tweet with the happy mood.
     *
     * @param message the base message
     * @return formatted message
     */
    String formatMessage(String message) {
        return "[Happy] " + message;
    }

}
