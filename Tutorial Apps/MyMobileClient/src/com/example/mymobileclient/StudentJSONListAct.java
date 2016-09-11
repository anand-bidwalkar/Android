package com.example.mymobileclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudentJSONListAct extends Activity 
{
	ListView lv;
	ArrayList<Student> listStudent=new ArrayList<Student>();
	ArrayAdapter<Student> adapter;	
	String url="http://192.168.0.84:8080/MyWebSite/StudentJSONListServlet";
	
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.list);
	lv=(ListView) findViewById(R.id.listView1);
	adapter=new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1,listStudent);
	
	ListTask task=new ListTask();
	task.execute(url);
	
	
}
 
 class ListTask extends AsyncTask<String, Void, String>
 {

 	@Override
 	protected String doInBackground(String... params) {
 		// TODO Auto-generated method stub
 		DefaultHttpClient client=new DefaultHttpClient();
 		HttpGet get=new HttpGet(params[0]);
 		String result=null;
 		try {
 			HttpResponse response=client.execute(get);
 			InputStream is=response.getEntity().getContent();
 			InputStreamReader isr=new InputStreamReader(is);
 			BufferedReader br=new BufferedReader(isr);
 			
 			String json=br.readLine();
 			if(json!=null)
 			{
 				try {
					JSONArray jarray=new JSONArray(json);
					for(int i=0;i<jarray.length();i++)
					{
						JSONObject obj=jarray.getJSONObject(i);
						String name=obj.getString("name");
						int rollno=obj.getInt("rollno");
						Student stu=new Student(name, rollno);
						listStudent.add(stu);
						
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 			
 			if(listStudent.size()>0)
 				return "success";
 		} catch (ClientProtocolException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			Log.e("err", e.toString());
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			Log.e("err", e.toString());
 		}
 		
 		return result;
 	}
 	@Override
 	protected void onPostExecute(String result) {
 		// TODO Auto-generated method stub
 		super.onPostExecute(result);
 		//tvResult.setText(result);
 		if(result.equals("success"))
 		{
 			lv.setAdapter(adapter);
 		}
 	}
 }
 
}
