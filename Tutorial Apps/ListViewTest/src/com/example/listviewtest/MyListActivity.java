package com.example.listviewtest;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListActivity extends ListActivity {
	ListView lv;
	ArrayList<String> slist;
	ArrayAdapter<String> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		lv=getListView();
		
		slist=new ArrayList<String>();
		slist.add("India");slist.add("Australlia");slist.add("America");slist.add("England");slist.add("Canada");
		
		adap=new ArrayAdapter<String>(MyListActivity.this, android.R.layout.simple_list_item_single_choice, slist);

		lv.setAdapter(adap);
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
	}
}
