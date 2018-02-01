/*
 * TweetTooLongException.java
 *
 * 31/01/18 5:44 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Represents a Tweet Too Long Exception.
 *
 * @author eyesniper2
 * @see Exception
 */
public class TweetTooLongException extends Exception {

    /**
     * Constructs the Tweet Too Long Exception
     *
     * @param e Exception message.
     */
    public TweetTooLongException(String e) {
        super(e);
    }

    /**
     * Constructs the Tweet Too Long Exception
     */
    public TweetTooLongException() {
        super();
    }
}
