package com.example.alarmservicedemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RealTimeAlarmActvity extends Activity {
Button btnSet, btnClear;
AlarmManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		am=(AlarmManager) getSystemService(ALARM_SERVICE);
		btnSet=(Button) findViewById(R.id.button1);
		btnClear=(Button) findViewById(R.id.button2);
		
		
		btnSet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent in=new Intent(RealTimeAlarmActvity.this,MyService.class);
				//create pending intent
				//PendingIntent pi=PendingIntent.getService(context, requestCode, intent, flags)
				PendingIntent pi=PendingIntent.getService(RealTimeAlarmActvity.this, 0, in, PendingIntent.FLAG_ONE_SHOT);
				
				//create time to launch component based on real clock time
				//find current time in ms
				//long time=System.currentTimeMillis();
				//find current date time of calder
				//Calendar cal=Calendar.getInstance();
				
				//3/11/2013 17:10:05;
				Calendar cal=Calendar.getInstance();
				cal.set(2013, 9, 21, 9,45, 5);
				
				//am.set(type, triggerAtMillis, operation)
				am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
				
				
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
