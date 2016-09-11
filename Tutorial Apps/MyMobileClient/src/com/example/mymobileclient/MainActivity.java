package com.example.mymobileclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
EditText etNum1, etNum2;
Button btnAdd;
TextView tvResult;
String url="http://192.168.0.84:8080/MyWebSite/AddServlet?";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnAdd= (Button) findViewById(R.id.button1);
		etNum1=(EditText) findViewById(R.id.editText1);
		etNum2=(EditText) findViewById(R.id.editText2);
		tvResult=(TextView) findViewById(R.id.textView2);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String n1=etNum1.getText().toString();
			String n2=etNum2.getText().toString();
			
			url=url+"num1="+n1+"&num2="+n2;
			
			AddTask task=new AddTask();
			task.execute(url);
			}
		});
		
	}
class AddTask extends AsyncTask<String, Void, String>
{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		DefaultHttpClient client=new DefaultHttpClient();
		HttpGet get=new HttpGet(params[0]);
		String result="";
		try {
			HttpResponse response=client.execute(get);
			InputStream is=response.getEntity().getContent();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String op=br.readLine();
			if(op==null)
				result= "nothing";
			else
				result =op;
			
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
		tvResult.setText(result);
	}
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
