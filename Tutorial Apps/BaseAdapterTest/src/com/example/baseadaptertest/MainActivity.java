package com.example.baseadaptertest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<Candidate> clist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.listView1);
		
		clist=new ArrayList<Candidate>();
		clist.add(new Candidate("Jai", "7894562310"));
		clist.add(new Candidate("Raj", "1234567890"));
		clist.add(new Candidate("Om", "4569871230"));
		clist.add(new Candidate("Prateek", "0154789632"));
		clist.add(new Candidate("Yash", "4125879630"));
		
		MyAdapter ma=new MyAdapter();
		
		lv.setAdapter(ma);
		
		
	}

	class MyAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return clist.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			Candidate c = clist.get(position);
			
			LayoutInflater linf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View v = linf.inflate(R.layout.customview, null);
			
			TextView tvName = (TextView) v.findViewById(R.id.tvName);
			TextView tvMobileno = (TextView) v.findViewById(R.id.tvMobileno);
			
			tvName.setText(c.getName());
			tvMobileno.setText(c.getMobileno());
			
			
			return v;
		}
		
	}
	
}
