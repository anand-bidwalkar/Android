package com.example.camerademo;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback
{
	Camera cam;
	SurfaceHolder holder; // actual obj to work on surfce of surfaceview

	public CameraPreview(Context context, Camera cam) {
		super(context);
		// TODO Auto-generated constructor stub
		this.cam=cam;
		holder=getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		Camera.Parameters cp= cam.getParameters();
		cp.setPreviewSize(height,width);
		cam.setParameters(cp);
		cam.startPreview();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		try {
			cam.setPreviewDisplay(holder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		cam.stopPreview();
		cam.release();
	}

}
