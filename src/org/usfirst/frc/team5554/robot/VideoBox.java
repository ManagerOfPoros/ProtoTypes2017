package org.usfirst.frc.team5554.robot;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

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
	
	public Mat DrawRec(Mat mat , Point leftUp , Point rightDown, Scalar rbg, int thickness)
	{
		Imgproc.rectangle(mat, leftUp, rightDown, rbg, thickness);
		return mat;
	}

}
