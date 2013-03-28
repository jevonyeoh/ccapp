package com.example.ccapp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.app.ListFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
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
        void onPhoneItemClick(String number);
        void onRemoveItemClick(String name);
        void onEditItemClick(String name, String number);
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
        
        Set<String> nameSet = map.keySet();
        String[] nameArray = nameSet.toArray(new String[0]);
        Arrays.sort(nameArray);
                
        int count = 0;
        while (count < nameArray.length) {
        	System.out.println(nameArray[count]);
        	names[count] = nameArray[count];
        	numbers[count] = map.get(nameArray[count]);
        	count++;
        }
        
        /** Creating an array adapter to store the list of countries **/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
 
        /** Setting the list adapter for the ListFragment */
        setListAdapter(adapter);
     
        return super.onCreateView(inflater, container, savedInstanceState);
    }
 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        registerForContextMenu(this.getListView());
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Options");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Remove");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle().equals("Edit")) {
        	ifaceItemClickListener.onEditItemClick(names[info.position], numbers[info.position]);
       } else if (item.getTitle().equals("Remove")) {
            ifaceItemClickListener.onRemoveItemClick(names[info.position]);
       }
        return super.onContextItemSelected(item);
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
 
        /** Invokes the implementation of the method onListFragmentItemClick in the hosting activity */
        ifaceItemClickListener.onPhoneItemClick(numbers[position]);
    }
}