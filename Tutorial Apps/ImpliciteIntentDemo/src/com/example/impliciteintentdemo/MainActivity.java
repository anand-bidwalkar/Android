package com.example.impliciteintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Button btnLaunch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLaunch=(Button) findViewById(R.id.button1);
btnLaunch.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	/*
	 * Intent in=new Intent();
	 
	in.setAction("android.intent.action.VIEW");
	startActivity(in);
	*/
		
	/*/ launch browser
		Intent in=new Intent();
		 
		in.setAction("android.intent.action.VIEW");
		
		String strUrl="http://www.yahoo.com";
		Uri uri=Uri.parse(strUrl);
		in.setData(uri);
		
		startActivity(in);
		*/
		// dial number
		Intent in=new Intent();
		 
		in.setAction(Intent.ACTION_CALL);
		
		String strnumber="tel:8788787878";
		Uri uri=Uri.parse(strnumber);
		in.setData(uri);
		
		startActivity(in);
		
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
