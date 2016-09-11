package com.example.listviewtest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SingleChoiceList extends Activity {
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
		
		//adap=new ArrayAdapter<String>(SingleChoiceList.this, android.R.layout.simple_list_item_single_choice, slist);
		adap=new ArrayAdapter<String>(SingleChoiceList.this, android.R.layout.simple_list_item_multiple_choice, slist);

		lv.setAdapter(adap);
//		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
//				slist.get(arg2);
			}
		});
	}
}
