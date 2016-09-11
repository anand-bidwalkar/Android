package com.example.androidthreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarDemo extends Activity {
TextView tv;
Button btn;

ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress);
		tv=(TextView) findViewById(R.id.textView1);
		btn=(Button) findViewById(R.id.button1);
		pb=(ProgressBar) findViewById(R.id.progressBar1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProgressThread pt=new ProgressThread();
				pt.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
class ProgressThread extends Thread
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<100;i++)
		{
			pb.setProgress(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


}