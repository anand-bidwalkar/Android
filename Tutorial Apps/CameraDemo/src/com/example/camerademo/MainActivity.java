package com.example.camerademo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
ImageView imgPic;
Button btnTakePick;
Camera cam;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imgPic=(ImageView) findViewById(R.id.imageView1);
		btnTakePick=(Button) findViewById(R.id.button1);
		
		btnTakePick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cam=Camera.open();
				if(cam==null)
				{
					Toast.makeText(MainActivity.this, "No camera !!!", 6).show();
				}
				else
				{
					//cam.takePicture(shutter, raw, jpeg)
					cam.takePicture(null, null, new MyCameraListener());
					
				}
				
			}
		});
	}
//create class to receive picture data
	class MyCameraListener implements Camera.PictureCallback
	{

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		// TODO Auto-generated method stub
		
		//Bitmap bmp=BitmapFactory.decodeByteArray(byte [], offset, length)
		Bitmap bmp=BitmapFactory.decodeByteArray(data, 0, data.length);
		imgPic.setImageBitmap(bmp);
		cam.release();
		
	}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
