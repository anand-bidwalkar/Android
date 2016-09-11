package com.example.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
TextView tv;
MyView v1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		v1=(MyView) findViewById(R.id.myView1);
		/*v1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "view clicked", 6).show();	
			}
		});*/
		v1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int x=(int) event.getX();
				int y=(int) event.getY();
				
				if((x>=10 && x<=30)&&(y>=10 && y<=30))
				Toast.makeText(MainActivity.this, "RED--"+x+":"+y, 6).show();
				if((x>=50 && x<=70)&&(y>=10 && y<=30))
					Toast.makeText(MainActivity.this, "BLUE--"+x+":"+y, 6).show();
					
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
