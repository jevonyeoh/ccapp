package com.example.ccapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addc);
	}
	
	public void onAddButtonClick(View view) {
		EditText name = (EditText)findViewById(R.id.names);
		EditText number = (EditText)findViewById(R.id.numbers);
		
		Intent i = new Intent();
		i.putExtra("NAME", name.getText().toString());
		i.putExtra("NUMBER", number.getText().toString());
		setResult(RESULT_OK, i);
		finish();
	}
	
	public void onCancelButtonClick(View view) {
		setResult(RESULT_CANCELED);
		finish();
	}
}
