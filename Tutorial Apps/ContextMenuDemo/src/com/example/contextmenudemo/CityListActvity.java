package com.example.contextmenudemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CityListActvity extends Activity {
TextView tv;

ListView lv;
ArrayList<String> alCity=new ArrayList<String>();
ArrayAdapter<String> adapter;

EditText et;
Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city);
		alCity.add("Betul");
		alCity.add("Mhow");
		alCity.add("Dewas");
		alCity.add("Ujjain");
		alCity.add("Bhopal");
		alCity.add("Gwalior");
		alCity.add("Indore");
		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alCity);
		
		lv=(ListView) findViewById(R.id.listView1);
		lv.setAdapter(adapter);
		
		tv=(TextView) findViewById(R.id.textView1);
		
		registerForContextMenu(lv);
		
		et=(EditText) findViewById(R.id.editText1);
		btn=(Button) findViewById(R.id.button11);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s=et.getText().toString();
				adapter.add(s);
			}
		});
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
		MenuInflater mi=getMenuInflater();
		mi.inflate(R.menu.listmenu, menu);
	}

 @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
	 int menuId=item.getItemId();
	  
	AdapterContextMenuInfo acmi=(
			AdapterContextMenuInfo)item.getMenuInfo();
	
	int pos=acmi.position;
	 
	 switch (menuId) {
	 
	case R.id.menuSelect:
		String s=adapter.getItem(pos);
		tv.setText(s);
		break;

	case R.id.menuRemove:
		//String s1=adapter.getItem(pos);
		//adapter.remove(s1);
		alCity.remove(pos);
		lv.setAdapter(adapter);
		
		break;
	default:
		break;
	}
	 
		return super.onContextItemSelected(item);
	}
}
