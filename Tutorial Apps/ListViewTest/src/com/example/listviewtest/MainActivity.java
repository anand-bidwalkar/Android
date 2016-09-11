package com.example.listviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView lv;
	String[] name;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.listView1);
		
		name=new String[]{"Raj","Ram","Yash","Sumit","Kant","Rajesh","Piyush","Yogesh","Suman","Harsh"};
		
		ArrayAdapter<String> adap = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name);
		
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
				
				String str = name[pos];
				
				Toast.makeText(MainActivity.this, "Hello "+str, 5).show();
				
			}
		});
		
	}

}
