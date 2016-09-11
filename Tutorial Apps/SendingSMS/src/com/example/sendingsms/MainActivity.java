package com.example.sendingsms;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
EditText etNum, etMsg;
Button btnSend;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etNum=(EditText) findViewById(R.id.editText2);
		etMsg=(EditText) findViewById(R.id.editText1);
		btnSend=(Button) findViewById(R.id.button1);
		
		
		btnSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				String num=etNum.getText().toString();
				String msg=etMsg.getText().toString();
				
				SmsManager manager=SmsManager.getDefault();
				//manager.sendTextMessage(destinationAddress, scAddress, text, sentIntent, deliveryIntent)
				manager.sendTextMessage(num, null, msg, null, null);
				
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
