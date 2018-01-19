package ca.ualberta.cs.lonelytwitter;


public class HappyMood extends Mood  {

    String formatMessage(String message) {
        return "[Happy] " + message;
    }

}
