package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.HashSet;

public abstract class Tweet implements Tweetable {

    private String message;
    private Date date;
    private HashSet<Mood> moods;

    Tweet(String message) {
        moods = new HashSet<Mood>();
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

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

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood) {
        moods.add(mood);
    }

    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    public abstract boolean isImportant();
}