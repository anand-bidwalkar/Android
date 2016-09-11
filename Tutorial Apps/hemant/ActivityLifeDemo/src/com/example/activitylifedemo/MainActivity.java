package com.example.activitylifedemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this, "On Create",Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast.makeText(this, "On Start",Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(this, "On Resume",Toast.LENGTH_LONG).show();
	}
@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	Toast.makeText(this, "On Pause",Toast.LENGTH_LONG).show();
	}
@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	Toast.makeText(this, "On Stop",Toast.LENGTH_LONG).show();
}
@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Toast.makeText(this, "On destroy",Toast.LENGTH_LONG).show();
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
