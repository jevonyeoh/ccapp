package com.example.ccapp.test;

import android.content.pm.PackageManager;
import com.example.ccapp.ButtonView;
import com.example.ccapp.ContactsActivity;
import com.example.ccapp.GamesActivity;
import com.example.ccapp.GamesMenu;
import com.example.ccapp.MainActivity;
import com.example.ccapp.MoreActivity;
import com.example.ccapp.R;
import com.example.ccapp.VoiceActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.ListFragment;
import android.os.SystemClock;
import android.provider.Browser;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MotionEvent;

public class GamesActivityTest extends ActivityInstrumentationTestCase2<GamesActivity> {
	
//	protected MainActivity main;
//	protected ButtonView buttonView;
//	protected ListFragment taskFrag;
	protected GamesActivity games;
	protected GamesMenu gamesmenu;
		
	public GamesActivityTest() {
		super(GamesActivity.class);
	}
		
	public void setUp() throws Exception {
		super.setUp();
		games = this.getActivity();
		gamesmenu = (GamesMenu) games.findViewById(R.id.gamesmenu);
		
	}

	// redirects to browser if app doesn't exist
	public void testGamesToBrowser() {
		assertNotNull(gamesmenu);
		
		String browser = "com.android.browser";
		ActivityMonitor monitor = getInstrumentation().addMonitor(games.getPackageManager().getLaunchIntentForPackage(browser).getClass().getName(),
                 null, true);
		
		games.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 100, 100, 0);
				// x > width/5 && x < width*2/5 && y > 0 && y < height; width = 480, height 150
				gamesmenu.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

	}	
	
	// goes to another app if it exists
	public void testGamesToCalendar() {
		assertNotNull(gamesmenu);
		
		String calendar = "com.android.calendar";
		ActivityMonitor monitor = getInstrumentation().addMonitor(games.getPackageManager().getLaunchIntentForPackage(calendar).getClass().getName(),
                 null, true);
		
		games.runOnUiThread(new Runnable() {
			public void run() {
				MotionEvent me = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 100, 300, 0);
				// x > width/5 && x < width*2/5 && y > 0 && y < height; width = 480, height 150
				gamesmenu.dispatchTouchEvent(me);
			}
		});
		// this waits for the UI to finish its stuff
		getInstrumentation().waitForIdleSync();

		assertTrue(getInstrumentation().checkMonitorHit(monitor, 1));
	}	
	
}
