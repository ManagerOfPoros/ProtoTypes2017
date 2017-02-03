package org.usfirst.frc.team5554.robot;

import org.opencv.core.Mat;

import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;

public class VideoBox
{

	private CvSource outputStream;
	
	public VideoBox(int width, int height, String name)
	{
		outputStream = CameraServer.getInstance().putVideo(name, width, height);
	}
	
	public void stream(Mat feed)
	{
		outputStream.putFrame(feed);
	}
	

}
