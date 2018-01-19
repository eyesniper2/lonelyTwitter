package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

public abstract class Mood {

    private Date date;

    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    Mood(Date date) {
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    abstract String formatMessage(String message);
 }
