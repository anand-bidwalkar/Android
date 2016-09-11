package com.example.spinnertest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Spinner_MainActivity extends Activity {
	Spinner spin;
	ArrayList<String> slist;
	ArrayAdapter<String> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spin=(Spinner) findViewById(R.id.spinner1);
		
		slist=new ArrayList<String>();
		slist.add("India");slist.add("Australlia");slist.add("America");slist.add("England");slist.add("Canada");
		
		adap=new ArrayAdapter<String>(Spinner_MainActivity.this, android.R.layout.simple_list_item_1,slist);
		spin.setAdapter(adap);
	}

}
