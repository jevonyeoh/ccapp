package com.example.ccapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCActivity extends MainActivity {
	
	String oldName = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editc);
		
		Intent i = getIntent();
		EditText name = (EditText)findViewById(R.id.names);
		EditText number = (EditText)findViewById(R.id.numbers);
		oldName = (String) i.getExtras().get("NAME");
		name.setText((String) i.getExtras().get("NAME"), EditText.BufferType.EDITABLE);
		number.setText((String) i.getExtras().get("NUMBER"), EditText.BufferType.EDITABLE);
	}
	
	public void onEditButtonClick(View view) {
		EditText name = (EditText)findViewById(R.id.names);
		EditText number = (EditText)findViewById(R.id.numbers);
		
		Intent i = new Intent();
		i.putExtra("OLD", oldName);
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
