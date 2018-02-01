/*
 * SadMood.java
 *
 * 31/01/18 5:54 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Represents a Sad Mood object.
 *
 * @author eyesniper2
 * @see Mood
 */
public class SadMood extends Mood {

    /**
     * Format the message of the tweet with the sad mood.
     *
     * @param message the base message
     * @return formatted message
     */
    String formatMessage(String message) {
        return "[Sad] " + message;
    }

}
