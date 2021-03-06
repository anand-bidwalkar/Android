package com.example.contetnproviderdemo;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReadSMSAct extends Activity {
ListView list;
ArrayList<String> dataList=new ArrayList<String>();
ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list=(ListView) findViewById(R.id.listView1);	
		//get uri
		String strUri="content://sms/sent";
		Uri uri=Uri.parse(strUri);
		
		//get data from uri
		ContentResolver resolver=getContentResolver();
		Cursor cur=resolver.query(uri, null, null, null, null);
		
		//print col name
		for(int i=0;i<cur.getColumnCount();i++)
		{
		String cn=cur.getColumnName(i);
		Log.e("col:", cn);
		}
		cur.close();
		
		String colNames[]={"_id","address","body","type"};
		 cur=resolver.query(uri, colNames, null, null, null);
		
		while(cur.moveToNext())
		{
			String s=cur.getString(0)+":"+cur.getString(1)+":"+cur.getString(2)+":"+cur.getString(3);
			dataList.add(s);
		}
		
		adapter=new ArrayAdapter<String>(ReadSMSAct.this, 
				android.R.layout.simple_list_item_1,dataList);
		
		list.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
