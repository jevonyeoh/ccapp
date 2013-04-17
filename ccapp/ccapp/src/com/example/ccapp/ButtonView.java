package com.example.ccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ButtonView extends View {

	protected ShapeDrawable button1, button2, button3, button4, button5;
	protected Paint text1, text2, text3, text4, text5;
	private static final int width = 480;
	private static final int height = 150;
	MainActivity m;
	
	public ButtonView(Context c) {
		super(c);
		init();
	}

	public ButtonView(Context c, AttributeSet a) {
		super(c, a);
		init();
	}
	
	protected void init() {
		button1 = new ShapeDrawable(new RectShape());
		button1.getPaint().setColor(Color.GRAY);
		button1.setBounds(0, 0, width/5, height);
		
		button2 = new ShapeDrawable(new RectShape());
		button2.getPaint().setColor(Color.BLACK);
		button2.setBounds(width/5, 0, width*2/5, height);
		
		button3 = new ShapeDrawable(new RectShape());
		button3.getPaint().setColor(Color.GRAY);
		button3.setBounds(width*2/5, 0, width*3/5, height);
		
		button4 = new ShapeDrawable(new RectShape());
		button4.getPaint().setColor(Color.BLACK);
		button4.setBounds(width*3/5, 0, width*4/5, height);
		
		button5 = new ShapeDrawable(new RectShape());
		button5.getPaint().setColor(Color.GRAY);
		button5.setBounds(width*4/5, 0, width, height);
		
		text1 = new Paint();
		text1.setColor(Color.BLACK);
		text1.setTextAlign(Paint.Align.LEFT);
		text1.setTypeface(Typeface.SANS_SERIF);
		text1.setTextSize(15);
		
		text2 = new Paint();
		text2.setColor(Color.WHITE);
		text2.setTextAlign(Paint.Align.LEFT);
		text2.setTypeface(Typeface.SANS_SERIF);
		text2.setTextSize(15);
		
		text3 = new Paint();
		text3.setColor(Color.BLACK);
		text3.setTextAlign(Paint.Align.LEFT);
		text3.setTypeface(Typeface.SANS_SERIF);
		text3.setTextSize(15);
		
		text4 = new Paint();
		text4.setColor(Color.WHITE);
		text4.setTextAlign(Paint.Align.LEFT);
		text4.setTypeface(Typeface.SANS_SERIF);
		text4.setTextSize(15);
		
		text5 = new Paint();
		text5.setColor(Color.BLACK);
		text5.setTextAlign(Paint.Align.LEFT);
		text5.setTypeface(Typeface.SANS_SERIF);
		text5.setTextSize(15);
	}
	
	protected void onDraw(Canvas canvas) {
		button1.draw(canvas);
		button2.draw(canvas);
		button3.draw(canvas);
		button4.draw(canvas);
		button5.draw(canvas);
		canvas.drawText("Voice", 30, height/2, text1);
		canvas.drawText("Contacts", width/5+15, height/2, text2);
		canvas.drawText("Friends", width*2/5+20, height/2, text3);
		canvas.drawText("Games", width*3/5+30, height/2, text4);
		canvas.drawText("More", width*4/5+30, height/2, text5);
	}
	
	public void setMainActivity(MainActivity main) {
		m = main;
	}
	
	public boolean onTouchEvent(MotionEvent e) {
		if(e.getAction() == MotionEvent.ACTION_DOWN) {
			int x = (int)e.getX();
			int y = (int)e.getY();
			if(x > 0 && x < width/5 && y > 0 && y < height) {	//Button 1
				m.onVoice();
				return true;
			}
			else if(x > width/5 && x < width*2/5 && y > 0 && y < height) {	//Button 2
				m.onContacts();
				return true;
			}
			else if(x > width*2/5 && x < width*3/5 && y > 0 && y < height) {	//Button 3
				m.onFriends();
				return true;
			}
			else if(x > width*3/5 && x < width*4/5 && y > 0 && y < height) {	//Button 4
				m.onGames();
				return true;
			}
			else if(x > width*4/5 && x < width && y > 0 && y < height) {	//Button 5
				m.onMore();
				return true;
			}
		}
		return false;
	}
}
