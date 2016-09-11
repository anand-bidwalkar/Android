package com.example.menutest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class Opt_Basic_MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuItem itemNew =  menu.add("New");
		menu.add("Open");
		menu.add("Save").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(getApplicationContext(), "Save Pressed", 5).show();
				return false;
			}
		});
		menu.add("Exit");
		menu.add("Save As");
		menu.add("Edit");
		menu.add("Delete");
		menu.add("Manage");
		
		itemNew.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(getApplicationContext(), "New Selected", 5).show();
				return false;
			}
		});
		
		return super.onCreateOptionsMenu(menu);
	}
}
