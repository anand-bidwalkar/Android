package com.example.camerademo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class CameraPreviewActvity extends Activity {
FrameLayout frame;
Button btnTakePick;
Camera cam;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview);
	
	frame=(FrameLayout) findViewById(R.id.frame1);
		btnTakePick=(	Button) findViewById(R.id.button1);
		cam=Camera.open();
		
		if(cam==null)
		{
			Toast.makeText(CameraPreviewActvity.this, "No camera !!!", 6).show();
		}
		else
		{
			CameraPreview preview=new CameraPreview(CameraPreviewActvity.this,cam);
			frame.addView(preview);
			Toast.makeText(CameraPreviewActvity.this, "open", 6).show();
		}
		
		btnTakePick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					cam.takePicture(null, null, new MyCameraListener());
					
				
				
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
		//imgPic.setImageBitmap(bmp);
		//cam.release();
		long num=System.currentTimeMillis();
		String pathFile=Environment.getExternalStorageDirectory().getPath()+"/photo"+num+".jpg";
		try {
			FileOutputStream stream=new FileOutputStream(pathFile);
			stream.write(data);
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cam.startPreview();
	}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
