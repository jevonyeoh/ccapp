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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButtonView button = (ButtonView)findViewById(R.id.button);
        button.setMainActivity(this);
    }
    
    public void onListFragmentItemClick(String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
        startActivity(callIntent);
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
    
    public void onAddButtonClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        
        Random r = new Random();
        int fourDigit = 1000 + r.nextInt(10000);
        String name = String.valueOf(fourDigit);
        
        editor.putString(name, "10101001"); // value to store
        editor.commit();
        
        finish();
        Intent i = new Intent(this, ContactsActivity.class);
        startActivity(i);

    }
    
    public void onRemoveButtonClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        
        editor.clear();
        editor.commit();
    }
}
