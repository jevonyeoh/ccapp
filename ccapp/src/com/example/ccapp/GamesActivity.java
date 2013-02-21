package com.example.ccapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

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
}
