package com.example.xmlparsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Shader.TileMode;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
ListView listView;
ArrayList<Score> titleList=new ArrayList<Score>();
ArrayAdapter<Score> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView1);
		adapter=new ArrayAdapter<Score>(this, 
				android.R.layout.simple_list_item_1,titleList);
		
		XmlPullParserFactory factory;
		try {
			factory = XmlPullParserFactory.newInstance();
		
         factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         // attach file with parser
         String filePath=Environment.getExternalStorageDirectory().getPath()+"/score.xml";
         FileReader reader=new FileReader(filePath);
 		 xpp.setInput(reader);
 		// start reading xml file
 		int event= xpp.next();
 		while(event!=xpp.END_DOCUMENT)
 		{
 			event=xpp.next();
 			if(event==xpp.START_TAG && xpp.getName().equalsIgnoreCase("item"))
 			{
 				Score score=new Score();
 				while(true)
 				{
 					event=xpp.next();
 					if(event==xpp.END_TAG && xpp.getName().equalsIgnoreCase("item"))
 						break;
 					
 					if(event==xpp.START_TAG && xpp.getName().equalsIgnoreCase("title"))
 		 			{
 		 				event=xpp.next();
 		 				String text=xpp.getText();
 		 				//Log.e("title:", text);
 		 				//titleList.add("title:"+text);
 		 				score.setTitle(text);
 		 			}
 		 			if(event==xpp.START_TAG && xpp.getName().equalsIgnoreCase("link"))
 		 			{
 		 				event=xpp.next();
 		 				String text=xpp.getText();
 		 				//Log.e("title:", text);
 		 				//titleList.add("link:"+text);
 		 				score.setLink(text);
 		 			}
 		 			
 				}
 				titleList.add(score);
 			}
 			
 			
 		}
 		listView.setAdapter(adapter);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
