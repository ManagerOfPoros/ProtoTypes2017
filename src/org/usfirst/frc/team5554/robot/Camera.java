package org.usfirst.frc.team5554.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Camera extends Thread
{
	private UsbCamera camera;
	private int cameraPort;
	private Mat mat = new Mat();
	private CvSink cvSink;	
	
	private boolean enabled = false;
	
	public Camera(int cameraPort , int resWidth, int resHeight , int fps)
	{
		this.cameraPort = cameraPort;
		camera = CameraServer.getInstance().startAutomaticCapture(this.cameraPort);
		camera.setResolution(resWidth, resHeight);
		camera.setFPS(fps);
		cvSink = CameraServer.getInstance().getVideo(camera);
		cvSink.setEnabled(enabled);
	}
	
	
	public Mat getFeed()
	{
			cvSink.grabFrame(mat);
			return mat;
	}
	
	
	public void SetStream(boolean enabled)
	{
		this.enabled = enabled;
		cvSink.setEnabled(enabled);
	}
	
	public boolean GetEnabled()
	{
		return enabled;
	}
}
