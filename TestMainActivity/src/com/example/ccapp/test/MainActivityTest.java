package com.example.ccapp.test;

import com.example.ccapp.ButtonView;
import com.example.ccapp.ContactsActivity;
import com.example.ccapp.GamesActivity;
import com.example.ccapp.MainActivity;
import com.example.ccapp.MoreActivity;
import com.example.ccapp.R;
import com.example.ccapp.VoiceActivity;

import android.app.Instrumentation.ActivityMonitor;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MotionEvent;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	protected MainActivity main;
	protected ButtonView buttonView;
		
	public MainActivityTest() {
		super(MainActivity.class);
	}
		
	public void setUp() throws Exception {
		super.setUp();
		main = this.getActivity();
		buttonView = (ButtonView)main.findViewById(R.id.button);
	}

	
	public void testMainToGames() {
		assertNotNull(buttonView);
		
		ActivityMonitor monitor = getInstrumentation().addMonitor(
                GamesActivity.class.getCanonicalName(), null, true);
		
		main.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 300, 50, 0);
				// x > width*3/5 && x < width*4/5 && y > 0 && y < height; width = 480, height 150
				buttonView.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

		assertTrue(getInstrumentation().checkMonitorHit(monitor, 1));
	}
	
	public void testMainToVoice() {
		assertNotNull(buttonView);
		
		ActivityMonitor monitor = getInstrumentation().addMonitor(
                VoiceActivity.class.getCanonicalName(), null, true);
		
		main.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 20, 50, 0);
				// x > 0 && x < width/5 && y > 0 && y < height; width = 480, height 150
				buttonView.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

		assertTrue(getInstrumentation().checkMonitorHit(monitor, 1));
	}	
	
	public void testMainToContacts() {
		assertNotNull(buttonView);
		
		ActivityMonitor monitor = getInstrumentation().addMonitor(
                ContactsActivity.class.getCanonicalName(), null, true);
		
		main.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 100, 50, 0);
				// x > width/5 && x < width*2/5 && y > 0 && y < height; width = 480, height 150
				buttonView.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

		assertTrue(getInstrumentation().checkMonitorHit(monitor, 1));
	}	
	
	public void testMainToMore() {
		assertNotNull(buttonView);
		
		ActivityMonitor monitor = getInstrumentation().addMonitor(
                MoreActivity.class.getCanonicalName(), null, true);
		
		main.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 450, 50, 0);
				// x > width*4/5 && x < width && y > 0 && y < height; width = 480, height 150
				buttonView.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

		assertTrue(getInstrumentation().checkMonitorHit(monitor, 1));
	}	
}
