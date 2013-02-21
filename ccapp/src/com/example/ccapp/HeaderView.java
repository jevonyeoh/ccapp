package com.example.ccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class HeaderView extends View {

	public HeaderView(Context c) {
		super(c);
		init();
	}
	
	public HeaderView(Context c, AttributeSet a) {
		super(c, a);
		init();
	}
	
	protected void init() {
		
	}
	
	protected void onDraw(Canvas canvas) {
		
	}
	
	public boolean onTouchEvent(MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int) e.getX();
			int y = (int) e.getY();
			
			if (x > 250 && y < 50) {
				
			}
			
		}
		
		return false;
	}
	
	
}