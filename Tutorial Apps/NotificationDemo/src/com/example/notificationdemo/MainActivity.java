package com.example.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
EditText etTitle, etDesc;
Button btnNotify;
NotificationManager nm;
int count=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etTitle=(EditText) findViewById(R.id.editText1);
		etDesc=(EditText) findViewById(R.id.editText2);
		btnNotify=(Button) findViewById(R.id.button1);
		
		nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		btnNotify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String title=etTitle.getText().toString();
				String desc=etDesc.getText().toString();
				Intent in=new Intent(MainActivity.this,NextActvity.class);
				in.putExtra("id", count);
				
				PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0, in,PendingIntent.FLAG_UPDATE_CURRENT);
				// create a notification using above values
				//Notification notice=new Notification(icon, tickerText, when)
				Notification notice=new Notification(R.drawable.ic_launcher,
						"a msg for u", System.currentTimeMillis());
				//set remaining things
				//notice.setLatestEventInfo(context, contentTitle, contentText, contentIntent)
				notice.setLatestEventInfo(MainActivity.this,
						title, desc, pi);
				
				// set notice
				//nm.notify(id, notification);
				nm.notify(count, notice);
				count++;
				
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
