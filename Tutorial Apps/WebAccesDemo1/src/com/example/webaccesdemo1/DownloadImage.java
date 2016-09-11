package com.example.webaccesdemo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DownloadImage extends Activity {
	Button btnDownload;
	ImageView image;
	String url = "http://l1.yimg.com/nn/fp/rsz/061013/images/smush/collagemannadey1024_1370839216.jpg";
	ProgressBar pb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		pb=(ProgressBar) findViewById(R.id.progressBar1);
		
		btnDownload = (Button) findViewById(R.id.button1);
		image=(ImageView) findViewById(R.id.imageView1);
		
		btnDownload.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DownloadTask task=new DownloadTask();
				task.execute(url);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
class DownloadTask extends AsyncTask<String, Integer, String>
{
	String filePath="";
	ProgressDialog dialog;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		Toast.makeText(DownloadImage.this, "downloding..",3).show();
		pb.setProgress(1);
		File sdPath=Environment.getExternalStorageDirectory();
		filePath=sdPath.getPath()+"/mannade.jpg";
		dialog=new ProgressDialog(DownloadImage.this);
		dialog.setTitle("downloading image...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setProgress(1);
		dialog.show();
		
		
		
	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		// create http connection with Server;
		DefaultHttpClient client=new DefaultHttpClient();
		//create a request object;
		HttpGet get=new HttpGet(params[0]);
		// send request
		try {
		HttpResponse response=client.execute(get);
		// read data from response
		long dataSize=response.getEntity().getContentLength();
		InputStream is=response.getEntity().getContent();
		
		// save in a jpg file
		FileOutputStream  fos=new FileOutputStream(filePath);
		double downloaded=0;
		while(true)
		{
			int d=is.read();
			
			if(d==-1)
				break;
			else
			{
				fos.write(d);
				downloaded++;
				double p=(downloaded/dataSize)*100;
				Log.e("pgress   ", p+"%");
				
				publishProgress((int)p);
			}
			
		}
		
		is.close();
		fos.flush();
		fos.close();
		
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "done";
	}
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		pb.setProgress(values[0]);
		dialog.setProgress(values[0]);
		
	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		Bitmap bmp=BitmapFactory.decodeFile(filePath);
		image.setImageBitmap(bmp);
		Toast.makeText(DownloadImage.this, result,3).show();
		dialog.dismiss();
	}
}
	

}
