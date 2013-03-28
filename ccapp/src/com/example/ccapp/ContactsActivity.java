package com.example.ccapp;

import java.util.Random;

import com.example.ccapp.NameList.ListFragmentItemClickListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class ContactsActivity extends MainActivity implements ListFragmentItemClickListener {
	
	public static final int AddC_ID = 1;
	public static final int EditC_ID = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		ButtonView button = (ButtonView)findViewById(R.id.button);
		button.setMainActivity(this);
	}
	
	public void onPhoneItemClick(String number) {
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:" + number));
		callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		startActivity(callIntent);
	}
	
	public void onRemoveItemClick(String name) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.remove(name);
		editor.commit();
		
		finish();
		Intent i = new Intent(this, ContactsActivity.class);
		startActivity(i);
	}
	
	public void onEditItemClick(String name, String number) {
		Intent i = new Intent(this, EditCActivity.class);
		i.putExtra("NAME", name);
		i.putExtra("NUMBER", number);
		startActivityForResult(i, EditC_ID);
	}
	
	public void onHomePageClick(View view) {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}
	
	public void onAddButtonClick(View view) {
		Intent i = new Intent(this, AddCActivity.class);
		startActivityForResult(i, AddC_ID);
	}
	
	public void onRemoveButtonClick(View view) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.clear();
		editor.commit();
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		
		switch(requestCode) {
			case AddC_ID:
				if(resultCode != RESULT_CANCELED) {
					String name = (String)(intent.getExtras().get("NAME"));
					String number = (String)(intent.getExtras().get("NUMBER"));
					
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
					SharedPreferences.Editor editor = prefs.edit();
					
					editor.putString(name, number); // value to store
					editor.commit();
					
					finish();
					Intent i = new Intent(this, ContactsActivity.class);
					startActivity(i);
				}
			case EditC_ID:
				if(resultCode != RESULT_CANCELED) {
					String old = (String)(intent.getExtras().get("OLD"));
					String name = (String)(intent.getExtras().get("NAME"));
					String number = (String)(intent.getExtras().get("NUMBER"));
					
					SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
					SharedPreferences.Editor editor = prefs.edit();
					
					editor.remove(old);
					editor.putString(name, number); // value to store
					editor.commit();
					
					finish();
					Intent i = new Intent(this, ContactsActivity.class);
					startActivity(i);
			}
		}
	}
}
