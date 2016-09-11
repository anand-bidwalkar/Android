package com.example.gridviewtest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	GridView gv;
	ArrayList<Integer> imglist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gv=(GridView) findViewById(R.id.gridView1);
		
		imglist=new ArrayList<Integer>();
		imglist.add(R.drawable.android_icon_125);
		imglist.add(R.drawable.ic_launcher);
		imglist.add(R.drawable.icon_contribute);
		imglist.add(R.drawable.icon_design);
		imglist.add(R.drawable.icon_download);
		imglist.add(R.drawable.icon_download2);
		imglist.add(R.drawable.icon_market);
		
		gv.setAdapter(new MyAdapter());
		
		//gv.setOnItemClickListener(listener)
		
	}
	class MyAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imglist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			
			int index=arg0;
			int imgid = imglist.get(index);
			
			LayoutInflater linf =  (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View v = linf.inflate(R.layout.mylayout, null);
			
			ImageView iv = (ImageView) v.findViewById(R.id.iv);
			iv.setImageResource(imgid);
			
			return v;
		}
		
	}
}
