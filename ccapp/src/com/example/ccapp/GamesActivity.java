package com.example.ccapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class GamesActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games);
	}
	
	public void onFinishButtonClick(View view) {
		Intent i = new Intent();
		setResult(RESULT_OK, i);
		
		finish();
	}
	
	public void onPanicButtonClick(View view) {
		Context context = getApplicationContext();
		CharSequence text = "You clicked the panic button!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	

	
	
}
