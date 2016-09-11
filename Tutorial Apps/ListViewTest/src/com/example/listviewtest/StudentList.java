package com.example.listviewtest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StudentList extends Activity {
	
	ListView lv;
	ArrayList<Student> slist;
	ArrayAdapter<Student> adap;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.listView1);
		
		slist=new ArrayList<Student>();
		slist.add(new Student(101, "Jai", 4520));
		slist.add(new Student(102, "Harsh", 4100));
		slist.add(new Student(103, "Yash", 5100));
		slist.add(new Student(104, "Vinay", 8900));
		slist.add(new Student(105, "Vinit", 12000));
		
		adap=new ArrayAdapter<Student>(StudentList.this, android.R.layout.simple_list_item_1,slist);
		
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				// TODO Auto-generated method stub
				Student s = adap.getItem(arg2);
				
				Toast.makeText(StudentList.this, s.getRno()+":"+s.getFees(), 5).show();
				
			}
		});
	}
}
