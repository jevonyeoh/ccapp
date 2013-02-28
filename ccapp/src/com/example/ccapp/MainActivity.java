package com.example.ccapp;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final int VoiceActivity_ID = 1;
	public static final int ContactsActivity_ID = 2;
	public static final int FriendsActivity_ID = 3;
	public static final int GamesActivity_ID = 4;
	public static final int MoreActivity_ID = 5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButtonView button = (ButtonView)findViewById(R.id.button);
		button.setMainActivity(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onVoice() {
		Intent i = new Intent(this, VoiceActivity.class);
		startActivityForResult(i, VoiceActivity_ID);
	}
	
	public void onContacts() {
		Intent i = new Intent(this, ContactsActivity.class);
		startActivityForResult(i, ContactsActivity_ID);
	}
	
	public void onFriends() {
		//Intent i = new Intent(this, FriendsActivity.class);
		//startActivityForResult(i, FriendsActivity_ID);
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com"));
		startActivity(browserIntent);
		
		
	}
	
	public void onGames() {
		Intent i = new Intent(this, GamesActivity.class);
		startActivityForResult(i, GamesActivity_ID);
	}

	public void onMore() {
		Intent i = new Intent(this, MoreActivity.class);
		startActivityForResult(i, MoreActivity_ID);
	}
	
	// this section connects to the other apps
	
	public void onGamesApp() {
		Intent intent = new Intent("android.intent.action.MAIN");
	    intent.setComponent(ComponentName.unflattenFromString("com.android.calendar"));
	    intent.addCategory("android.intent.category.LAUNCHER");
	    startActivity(intent);
	}
	
	public void onPanicButtonClick(View view) {
		//Context context = getApplicationContext();
		//CharSequence text = "You clicked the panic button!";
		//int duration = Toast.LENGTH_SHORT;

		//Toast toast = Toast.makeText(context, text, duration);
		//toast.show();
		
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:2152790135"));
		callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		startActivity(callIntent);
		
	}
}
