package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View
{

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
@Override
protected void onDraw(Canvas canvas) {
	// TODO Auto-generated method stub
	super.onDraw(canvas);
	Paint p=new Paint();
	p.setColor(Color.RED);
	canvas.drawCircle(20, 20, 10, p);
	
	p.setColor(Color.BLUE);
	canvas.drawCircle(60, 20, 10, p);
	
}
}
