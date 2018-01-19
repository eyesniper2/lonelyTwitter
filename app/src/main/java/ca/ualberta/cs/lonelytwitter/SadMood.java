package ca.ualberta.cs.lonelytwitter;


public class SadMood extends Mood {

    String formatMessage(String message) {
        return "[Sad] " + message;
    }

}
