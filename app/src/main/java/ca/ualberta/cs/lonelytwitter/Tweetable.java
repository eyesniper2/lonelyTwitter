package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

public interface Tweetable {

    String getMessage();

    void setMessage(String message) throws TweetTooLongException;

    Date getDate();

    void setDate(Date date);
}
