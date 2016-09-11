package com.example.menutest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class Opt_2_MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		menu.add(1, 101, 5, "Save");
//		menu.add(2, 102, 4, "Delete");
//		menu.add(3, 103, 1, "New");
//		menu.add(4, 104, 3, "Exit");
//		menu.add(5, 105, 2, "Open");
		
		menu.add(1, 101, 5, "Save");
		menu.add(1, 102, 4, "Delete");
		menu.add(3, 103, 1, "New");
		menu.add(2, 104, 3, "Exit");
		menu.add(1, 105, 2, "Open");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//		int id = item.getItemId();
//		
//		switch (id) {
//		case 101:
//			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
//			break;
//		case 102:
//			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
//			break;
//		case 103:
//			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
//			break;
//		case 104:
//			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
//			break;
//		case 105:
//			Toast.makeText(getApplicationContext(), item.getTitle(), 5).show();
//			break;
//		default:
//			break;
//		}
		
		int groupid = item.getGroupId();
		
		switch (groupid) {
		case 1:
			Toast.makeText(getApplicationContext(), item.getTitle()+" group is "+ groupid, 5).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), item.getTitle()+" group is "+ groupid, 5).show();
			break;
		case 3:
			Toast.makeText(getApplicationContext(), item.getTitle()+" group is "+ groupid, 5).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
