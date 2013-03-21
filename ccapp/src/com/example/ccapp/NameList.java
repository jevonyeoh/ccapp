package com.example.ccapp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.app.ListFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
 
public class NameList extends ListFragment {
 
	String[] names;
	String[] numbers;
	
    /*String[] names = new String[] {
        "Adam",
        "Bob",
        "Carrie",
        "Dylan",
        "Edith",
        "Francis",
        "Ginny",
        "Hubert",
        "Ian",
        "Jasper"
    };
    
    String[] numbers = new String[] {
    	"2152790130",
    	"2152790131",
    	"2152790132",
    	"2152790133",
    	"2152790134",
    	"2152790135",
    	"2152790136",
    	"2152790137",
    	"2152790138",
    	"2152790139"
    };*/
 
    ListFragmentItemClickListener ifaceItemClickListener;
    
    /** An interface for defining the callback method */
    public interface ListFragmentItemClickListener {
        /** This method will be invoked when an item in the ListFragment is clicked */
        void onListFragmentItemClick(String number);
    }
    
    /** A callback function, executed when this fragment is attached to an activity */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            /** This statement ensures that the hosting activity implements ListFragmentItemClickListener */
            ifaceItemClickListener = (ListFragmentItemClickListener) activity;
        }catch(Exception e){
            Toast.makeText(activity.getBaseContext(), "Exception",Toast.LENGTH_SHORT).show();
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
    	HashMap<String, String> map = (HashMap<String, String>)prefs.getAll();
    	
    	names = new String[map.size()];
    	numbers = new String[map.size()];
    	
    	int count = 0;
    	for(Map.Entry<String,String> entry : map.entrySet()){
    	    names[count] = entry.getKey();
    	    numbers[count] = entry.getValue();
    	    count++;
    	}
    	
        /** Creating an array adapter to store the list of countries **/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
 
        /** Setting the list adapter for the ListFragment */
        setListAdapter(adapter);
        
        //View v = inflater.inflate(R.layout.activity_contacts, container, false);

        //Button b = (Button)v.findViewById(R.id.add);
        //b.setOnClickListener(this);
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
 
        /** Invokes the implementation of the method onListFragmentItemClick in the hosting activity */
        ifaceItemClickListener.onListFragmentItemClick(numbers[position]);
    }

	/*public void onClick(View v) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
		SharedPreferences.Editor editor = prefs.edit();
		
		Random r = new Random();
		int fourDigit = 1000 + r.nextInt(10000);
		String name = String.valueOf(fourDigit);
		
		editor.putString(name, "10101001"); // value to store
		editor.commit();
		
		load(prefs);
	}*/
	
	/*public void load(SharedPreferences prefs) {
		HashMap<String, String> map = (HashMap<String, String>)prefs.getAll();
    	
    	names = new String[map.size()];
    	numbers = new String[map.size()];
    	
    	int count = 0;
    	for(Map.Entry<String,String> entry : map.entrySet()){
    	    names[count] = entry.getKey();
    	    numbers[count] = entry.getValue();
    	    count++;
    	}
	}*/
}
