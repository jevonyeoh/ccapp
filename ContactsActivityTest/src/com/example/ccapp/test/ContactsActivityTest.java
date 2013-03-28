package com.example.ccapp.test;

import com.example.ccapp.ButtonView;
import com.example.ccapp.ContactsActivity;
import com.example.ccapp.MainActivity;
import com.example.ccapp.R;

import android.app.ListFragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.view.KeyEvent;

public class ContactsActivityTest extends ActivityInstrumentationTestCase2<ContactsActivity> {
	
	protected ContactsActivity ca;
	protected ButtonView buttonView;
	
	public ContactsActivityTest() {
		super(ContactsActivity.class);	
	}
	
	public void setup() throws Exception {
		super.setUp();
		ca = this.getActivity();
		buttonView = (ButtonView) ca.findViewById(R.id.button);
		setActivityInitialTouchMode(false);
	}
	
	public void testAddContact() {
		Intent i = new Intent();
		i.putExtra("NAME", "yeongwei");
		i.putExtra("NUMBER", "12345");
		ca.onActivityResult(1, -1, i);
		assertEquals(1, ca.numberContacts);
	}
	
	public void testRemoveContact() {
		Intent i = new Intent();
		i.putExtra("NAME", "yeongwei");
		i.putExtra("NUMBER", "12345");
		ca.onActivityResult(1, -1, i);
		assertEquals(1, ca.numberContacts);
		
		ca.onRemoveItemClick("yeongwei");
		assertEquals(0, ca.numberContacts);
	}
	
	public void testEditContact() {
		Intent i = new Intent();
		i.putExtra("NAME", "yeongwei");
		i.putExtra("NUMBER", "12345");
		ca.onActivityResult(1, -1, i);
		assertEquals(1, ca.numberContacts);
		
		ca.onEditItemClick("yeongwei", "23456");
		assertEquals(1, ca.numberContacts);
	}

}
