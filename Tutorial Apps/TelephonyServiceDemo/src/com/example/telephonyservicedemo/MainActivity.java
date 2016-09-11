package com.example.telephonyservicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
TextView tv;
TelephonyManager tm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView) findViewById(R.id.textView1);
		
		tm=(TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String num=tm.getLine1Number();
		tv.setText(num);
		
		tm.listen(new MyPhoneStateListener(), PhoneStateListener.LISTEN_CALL_STATE);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
//to handle phone call states
	class MyPhoneStateListener extends PhoneStateListener
	{
		
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				Toast.makeText(MainActivity.this, "idle:"+incomingNumber, 3).show();
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Toast.makeText(MainActivity.this, "ringing:"+incomingNumber, 3).show();
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				Toast.makeText(MainActivity.this, "offhook:"+incomingNumber, 3).show();
				break;
			default:
				break;
			}
		}
	}
}
