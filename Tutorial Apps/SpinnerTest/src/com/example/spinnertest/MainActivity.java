package com.example.spinnertest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	AutoCompleteTextView autotv;
	ArrayList<String> slist;
	ArrayAdapter<String> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocompleteview);
		autotv=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		
		slist=new ArrayList<String>();
		slist.add("India");slist.add("Indonesia");slist.add("America");slist.add("England");slist.add("Australlia");
		
		
		
		adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,slist);
		autotv.setThreshold(1);
		autotv.setAdapter(adap);
	}

}
