package com.example.ccapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

public class ButtonView extends View {

	protected ShapeDrawable button1, button2, button3, button4, button5;
	protected Paint text1, text2, text3, text4, text5;
	
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
		button1.setBounds(0, 0, 100, 150);
		
		button2 = new ShapeDrawable(new RectShape());
		button2.getPaint().setColor(Color.BLACK);
		button2.setBounds(100, 0, 200, 150);
		
		button3 = new ShapeDrawable(new RectShape());
		button3.getPaint().setColor(Color.GRAY);
		button3.setBounds(200, 0, 300, 150);
		
		button4 = new ShapeDrawable(new RectShape());
		button4.getPaint().setColor(Color.BLACK);
		button4.setBounds(300, 0, 400, 150);
		
		button5 = new ShapeDrawable(new RectShape());
		button5.getPaint().setColor(Color.GRAY);
		button5.setBounds(400, 0, 500, 150);
		
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
		canvas.drawText("Voice", 30, 70, text1);
		canvas.drawText("Contacts", 115, 70, text2);
		canvas.drawText("Friends", 220, 70, text3);
		canvas.drawText("Games", 330, 70, text4);
		canvas.drawText("More", 430, 70, text5);
	}
}
