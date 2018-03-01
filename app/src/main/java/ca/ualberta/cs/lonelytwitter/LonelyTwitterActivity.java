package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LonelyTwitterActivity extends Activity {

    private LonelyTwitterActivity activity = this;

	//private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweet> tweetList = new ArrayList<NormalTweet>();
	private ArrayAdapter<NormalTweet> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				NormalTweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				ElasticsearchTweetController.AddTweetsTask addTweetsTask = new ElasticsearchTweetController.AddTweetsTask();
				addTweetsTask.execute(newTweet);
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				String text = bodyText.getText().toString();
				ElasticsearchTweetController.GetTweetsTask getTweetsTask = new ElasticsearchTweetController.GetTweetsTask();
				String query = "{ \"query\": { \"term\" : { \"message\" : \"" + text + "\"} } }";
				if(text.length() == 0){
					query = "";
				}
				getTweetsTask.execute(query);
				try {
					tweetList.clear();
					tweetList.addAll(getTweetsTask.get());
				} catch (InterruptedException e) {
					Log.i("Error", "Failed to get the tweets from the async object");
				} catch (ExecutionException e) {
					Log.i("Error", "Failed to get the tweets from the async object");
				}
				adapter.notifyDataSetChanged();
				for(NormalTweet t : tweetList){
					Log.i("Data", t.getMessage());
				}
			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

		    @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		        Intent intent = new Intent(getBaseContext(), EditTweetActivity.class);
		        intent.putExtra("tweet", tweetList.get(i).getMessage());
		        startActivity(intent);
            }

        });

	}

	@Override
	protected void onStart() {
		super.onStart();
		ElasticsearchTweetController.GetTweetsTask getTweetsTask = new ElasticsearchTweetController.GetTweetsTask();
		getTweetsTask.execute("");
		try {
			tweetList = getTweetsTask.get();
		} catch (InterruptedException e) {
			Log.i("Error", "Failed to get the tweets from the async object");
		} catch (ExecutionException e) {
			Log.i("Error", "Failed to get the tweets from the async object");
		}
		adapter = new ArrayAdapter<NormalTweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	public ListView getOldTweetList(){
		return oldTweetsList;
	}


}