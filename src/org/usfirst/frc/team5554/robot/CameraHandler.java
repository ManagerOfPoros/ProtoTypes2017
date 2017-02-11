package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoException;


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
	
	
	
	private void AddCamera(int idx, int width , int height)
	{
		if(!cvSinks.containsKey(idx))
		{
			try
			{
				cvSinks.put(idx, new CvSink("cam"+String.valueOf(idx)));
				UsbCamera cam = new UsbCamera("cam"+String.valueOf(idx) , idx);
				cam.setResolution(width, height);
				cam.setFPS(30);
				cvSinks.get(idx).setSource(cam);
				cvSinks.get(idx).setEnabled(false);
				
			}
			catch(VideoException e)
			{
				System.out.println("Failed to initialize camera on port: " + idx);
				throw(e);
			}
		}
		else
		{
			System.out.println("Camera on port " + idx + " is already defined.");
		}
	}
	
	public void SetStreamer(int idx)
	{
		if(idx != currentCamera)
		{
			cvSinks.get(currentCamera).setEnabled(false);
			cvSinks.get(idx).setEnabled(true);
			currentCamera = idx;
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
