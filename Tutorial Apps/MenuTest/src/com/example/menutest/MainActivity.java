package com.example.menutest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		MenuInflater minf = getMenuInflater();
		minf.inflate(R.menu.myoptmenu, menu);
		
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.mnuNew:
			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
			break;
		case R.id.mnuExit:
			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
}
