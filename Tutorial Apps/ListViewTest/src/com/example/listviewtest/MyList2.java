package com.example.listviewtest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyList2 extends Activity {
	
	ListView lv;
	ArrayList<String> slist;
	ArrayAdapter<String> adap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.listView1);
		
		slist=new ArrayList<String>();
		slist.add("India");slist.add("Australlia");slist.add("America");slist.add("England");slist.add("Canada");
		
		adap=new ArrayAdapter<String>(MyList2.this, android.R.layout.simple_list_item_1, slist);

		lv.setAdapter(adap);
	}
}
