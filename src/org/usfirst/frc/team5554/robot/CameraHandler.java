package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;


public class CameraHandler 
{
	private Map<Integer , CvSink> cvSinks = new HashMap<>();
	
	
	public void AddCamera(int port)
	{
		cvSinks.put(port, new CvSink("cam0"));
		UsbCamera cam = new UsbCamera("cam0", 0);
		cam.free();
		cvSinks.get("cam0").setSource(cam);
	}
}
