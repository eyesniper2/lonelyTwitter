package ca.ualberta.cs.lonelytwitter;


public class TweetTooLongException extends Exception {

    public TweetTooLongException(String e) {
        super(e);
    }

    public TweetTooLongException() {
        super();
    }
}
