package com.example.contextmenudemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tv;
ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView) findViewById(R.id.textView1);		
		//on long press tv a menu will appear
		registerForContextMenu(tv);
		
		image=(ImageView)findViewById(R.id.imageView1);
		registerForContextMenu(image);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		int id=v.getId();
		switch (id) {
		case R.id.textView1:
			getMenuInflater().inflate(R.menu.textmenu, menu);	
			break;
		case R.id.imageView1:
			getMenuInflater().inflate(R.menu.imagemenu, menu);
		break;
		default:
			break;
		}
		
		
	}

 @Override
	public boolean onContextItemSelected(MenuItem item)
 {
		// TODO Auto-generated method stub
	   int menuId=item.getItemId();
	   switch (menuId) {
	case R.id.menuBlueHill:
		image.setImageResource(R.drawable.bluehills);
		break;
		
	case R.id.menuSunset:
		image.setImageResource(R.drawable.sunset);
		break;
		
	case R.id.menuRed:
		tv.setTextColor(Color.RED);
		break;

	case R.id.menuGree:
		tv.setTextColor(Color.GREEN);
		break;
	case R.id.menuBlue:
		tv.setTextColor(Color.BLUE);
		break;

	default:
		break;
	}
	 
		return super.onContextItemSelected(item);
	}
}
