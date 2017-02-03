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
	
	public Camera(int cameraPort , int resWidth, int resHeight)
	{
		this.cameraPort = cameraPort;
		camera = CameraServer.getInstance().startAutomaticCapture(this.cameraPort);
		camera.setResolution(resWidth, resHeight);
		cvSink = CameraServer.getInstance().getVideo(camera);
	}
	
	
	public Mat getFeed()
	{
			cvSink.grabFrame(mat);
			return mat;		
	}
	
	public UsbCamera GetCamera()
	{
		return camera;
	}
}
