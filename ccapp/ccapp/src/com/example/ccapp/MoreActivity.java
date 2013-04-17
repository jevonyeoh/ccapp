package com.example.ccapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MoreActivity extends MainActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);
		ButtonView button = (ButtonView)findViewById(R.id.button);
		button.setMainActivity(this);
	}
	
	
	public void onHomePageClick(View view) {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}
}
