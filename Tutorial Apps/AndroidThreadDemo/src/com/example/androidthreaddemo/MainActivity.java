package com.example.androidthreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tv;
Button btn;
MyHandler mh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView) findViewById(R.id.textView1);
		btn=(Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mh=new MyHandler();
				CountThread ct=new CountThread();
				ct.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
//
class MyHandler extends Handler
{
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		Bundle bn=msg.getData();
		int c=bn.getInt("count");
		tv.setText(c+"");
	}
}
class CountThread extends Thread
{	
	public void run() 
	{
		for(int i=0;i<=10;i++)
		{
			//tv.setText(i+"");
			Bundle bn=new Bundle();
			bn.putInt("count", i);
			Message msg=new Message();
			msg.setData(bn);
			mh.sendMessage(msg);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}