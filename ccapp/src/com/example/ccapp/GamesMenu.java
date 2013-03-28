package com.example.ccapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GamesMenu extends View {

	protected ShapeDrawable app1, app2, app3, app4;
	protected Paint apptext;
	MainActivity m;
	
	public GamesMenu(Context c) {
		super(c);

		init();
		/*
		setHorizontalScrollBarEnabled(true);
		setVerticalScrollBarEnabled(true);
		TypedArray a = c.obtainStyledAttributes(R.styleable.View);
		initializeScrollbars(a);
		a.recycle();*/
	}

	public GamesMenu(Context c, AttributeSet a) {
		super(c, a);

		init();
		
		/*
		setHorizontalScrollBarEnabled(true);
		setVerticalScrollBarEnabled(true);
		TypedArray ta = c.obtainStyledAttributes(R.styleable.View);
		initializeScrollbars(ta);
		ta.recycle();*/
		
	}
	
	protected void init() {
		app1 = new ShapeDrawable(new RectShape());
		app1.getPaint().setColor(Color.RED);
		app1.setBounds(50, 50, 200, 200);
		
		app2 = new ShapeDrawable(new RectShape());
		app2.getPaint().setColor(Color.RED);
		app2.setBounds(250, 50, 400, 200);
		
		app3 = new ShapeDrawable(new RectShape());
		app3.getPaint().setColor(Color.RED);
		app3.setBounds(50, 250, 200, 400);
		
		app4 = new ShapeDrawable(new RectShape());
		app4.getPaint().setColor(Color.RED);
		app4.setBounds(250, 250, 400, 400);
		
		apptext = new Paint();
		apptext.setColor(Color.BLACK);
		apptext.setTextAlign(Paint.Align.LEFT);
		apptext.setTypeface(Typeface.SANS_SERIF);
		apptext.setTextSize(15);
		
	}
	
	protected void onDraw(Canvas canvas) {
		app1.draw(canvas);
		app2.draw(canvas);
		app3.draw(canvas);
		app4.draw(canvas);
		canvas.drawText("Memory", 100, 100, apptext);
		canvas.drawText("Speed", 300, 100, apptext);
		canvas.drawText("Co-ordination", 100, 300, apptext);
		canvas.drawText("Attention", 300, 300, apptext);
	}
	
	public void setMainActivity(MainActivity main) {
		m = main;
	}
	
	public boolean onTouchEvent(MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int)e.getX();
			int y = (int)e.getY();
			
			if(x > 50 && x < 200 && y > 50 && y < 200) {	//App 1
				m.onGamesApp("fake");

				return true;
			}
			else if(x > 250 && x < 400 && y > 50 && y < 200) {	//App 2
				m.onGamesApp("fake2");

				return true;
			}
			
			else if(x > 50 && x < 200 && y > 250 && y < 400) {	//App 3
				m.onGamesApp("com.android.calendar");

				return true;
			}
			else if(x > 250 && x < 400 && y > 250 && y < 400) {	//App 4
				m.onGamesApp("fake3");

				return true;
			}

		}
		return false;
	}
}