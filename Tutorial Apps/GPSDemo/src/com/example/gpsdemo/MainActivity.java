package com.example.gpsdemo;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
LocationManager lm;
TextView tvLoc;
String strLocUrl="https://maps.google.co.in/maps";
Button btnMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvLoc=(TextView) findViewById(R.id.textView1);
		btnMap=(Button) findViewById(R.id.button1);
		
		
		
		lm=(LocationManager) getSystemService(LOCATION_SERVICE);
		//lm.requestLocationUpdates(provider, minTime(milli second), minDistance(meter), listener)
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, new MyLocListener());
		
		btnMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent();
				in.setAction(Intent.ACTION_VIEW);
				
				Uri uri=Uri.parse(strLocUrl);
				in.setData(uri);
				
				startActivity(in);
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class MyLocListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			double lat=location.getLatitude();
			double lon=location.getLongitude();
			double alt=location.getAltitude();
			long time=location.getTime();
			
			tvLoc.setText(lat+":"+lon);
			strLocUrl="https://maps.google.co.in/maps?q="+lat+","+lon;
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}

