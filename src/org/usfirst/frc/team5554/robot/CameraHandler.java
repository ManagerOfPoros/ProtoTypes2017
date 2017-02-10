package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;


public class CameraHandler 
{
	private Map<Integer , CvSink> cvSinks = new HashMap<>();
	private int currentCamera; //The port of the current camera
	private Mat mat;
	
	public CameraHandler(int[] ports,int width, int height)
	{
		
		mat = new Mat();
		for(int i = 0; i < ports.length; i++)
		{
			AddCamera(i, width, height);
		}
	}
	
	
	
	private void AddCamera(int port, int width , int height)
	{
		if(!cvSinks.containsKey(port))
		{
			try
			{
				cvSinks.put(port, new CvSink("cam"+String.valueOf(port)));
				UsbCamera cam = new UsbCamera("cam"+String.valueOf(port) , port);
				cam.setResolution(width, height);
				cam.setFPS(15);
				cvSinks.get(port).setSource(cam);
				cvSinks.get(port).setEnabled(false);
				
			}
			catch(Exception e)
			{
				System.out.println("Failed to initialize camera on port: " + port);
				throw(e);
			}
		}
		else
		{
			System.out.println("Camera on port " + port + " is already defined.");
		}
	}
	
	public void SetStreamer(int cameraPort)
	{
		if(cameraPort != currentCamera)
		{
			cvSinks.get(currentCamera).setEnabled(false);
			cvSinks.get(cameraPort).setEnabled(true);
			currentCamera = cameraPort;
		}
	}
	
	public Mat GetStream()
	{
		cvSinks.get(currentCamera).grabFrame(mat);
		return mat;
	}
	
	public void DeleteHandler()
	{
		cvSinks.clear();
	}
	
}
