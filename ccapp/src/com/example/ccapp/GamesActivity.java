package com.example.ccapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class GamesActivity extends MainActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games);
		ButtonView button = (ButtonView)findViewById(R.id.button);
		GamesMenu gamesmenu = (GamesMenu)findViewById(R.id.gamesmenu);
		button.setMainActivity(this);
		gamesmenu.setMainActivity(this);
	}
	
	public void onPanicButtonClick(View view) {
		Context context = getApplicationContext();
		CharSequence text = "You clicked the panic button!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	public void onHomePageClick(View view) {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}
}
