package ca.ualberta.cs.lonelytwitter;


public class AngryMood extends Mood{

    String formatMessage(String message) {
        return "[Angry] " + message;
    }

}
