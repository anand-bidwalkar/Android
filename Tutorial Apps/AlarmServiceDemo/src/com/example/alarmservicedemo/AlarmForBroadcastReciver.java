package com.example.alarmservicedemo;

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

public class AlarmForBroadcastReciver extends Activity {
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
			
				Intent in=new Intent();
				in.setAction("com.example.alarmservicedemo.MyAction");
				in.putExtra("mydata", "Naveen+Ankit");
				//create pending intent
				//PendingIntent pi=PendingIntent.getService(context, requestCode, intent, flags)
				PendingIntent pi=PendingIntent.getBroadcast(AlarmForBroadcastReciver.this,
						0, in, PendingIntent.FLAG_UPDATE_CURRENT);
				
				//create time to launch component
				long time=SystemClock.elapsedRealtime()+10000;
				//pass this time and PI to alarm manager
				//am.set(type, triggerAtMillis, operation)
				am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, time, pi);
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
