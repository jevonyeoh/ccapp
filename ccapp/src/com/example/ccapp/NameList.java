package com.example.ccapp;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
 
public class NameList extends ListFragment {
 
    String[] names = new String[] {
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
    };
 
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        /** Creating an array adapter to store the list of countries **/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
 
        /** Setting the list adapter for the ListFragment */
        setListAdapter(adapter);
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
 
        /** Invokes the implementation of the method onListFragmentItemClick in the hosting activity */
        ifaceItemClickListener.onListFragmentItemClick(numbers[position]);
    }
}
