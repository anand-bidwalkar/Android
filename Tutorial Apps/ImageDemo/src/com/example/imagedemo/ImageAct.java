package com.example.imagedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageAct extends Activity implements OnClickListener
{
	Button buttonWinter, buttonSunset;
	ImageView iv;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view2);
	buttonSunset=(Button) findViewById(R.id.buttonSunset);
	buttonWinter=(Button) findViewById(R.id.buttonWinter);
	iv=(ImageView) findViewById(R.id.imageView1);
	
	buttonSunset.setOnClickListener(this);
	buttonWinter.setOnClickListener(this);
	
}
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	int buttonId=v.getId();
	switch (buttonId) {
	case R.id.buttonSunset:
		iv.setImageResource(R.drawable.sunset);
		break;
	case R.id.buttonWinter:
	   iv.setImageResource(R.drawable.blue_hills);
	   break;

	default:
		break;
	}
}
}
