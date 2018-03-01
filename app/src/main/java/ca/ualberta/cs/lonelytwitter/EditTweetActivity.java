/*
 * EditTweetActivity.java
 *
 * 28/02/18 5:52 PM
 *
 * Copyright @ 2018 Team X CMPUT 301, University of Alberta, All Rights Reserved.
 */

package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getExtras().getString("tweet"));
    }
}
