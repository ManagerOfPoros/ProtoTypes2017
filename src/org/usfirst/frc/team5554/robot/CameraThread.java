package org.usfirst.frc.team5554.robot;

import org.opencv.core.Point;
import org.opencv.core.Scalar;

import edu.wpi.first.wpilibj.Joystick;

public class CameraThread extends Thread
{
	private Joystick joy;
	public boolean toSwitch = false;
	
	public CameraThread(Joystick operator)
	{
		joy = operator;
	}
	
	@Override
	
	public void run()
	{		
		
		Camera camera0 = new Camera(0,320,240,15);
		Camera camera1 = new Camera(1,320,240,15);

		VideoBox screen = new VideoBox(320 , 240 , "Live Feed");

		int liveCamera = 0;
		
		while (!Thread.interrupted()) 
		{
			//This if steatment decides which camera to stream
			if(toSwitch)
			{			
				if(joy.getRawAxis(1) >= 0.15 )
				{
					liveCamera = 1;
				}
				else
				{
					liveCamera = 0;
				}
			}
			else
			{
				liveCamera = 0;
			}
			
			
			//The stream
			if(liveCamera == 0)
			{
				if(camera1.GetEnabled() == true)
				{
					camera1.SetStream(false);
				}
				
				if(camera0.GetEnabled() == false)
				{
					camera0.SetStream(true);
				}
				
				if(joy.getRawButton(5))
				{
					screen.stream(screen.DrawRec(
							screen.DrawRec(camera0.getFeed(), new Point(200,50), new Point(250,150), new Scalar(255,255,255), 1)
								,new Point(50,50) , new Point(100,150), new Scalar(255,255,255), 1));
				}
				else
				{
					screen.stream(camera0.getFeed());
				}
			}
			else if(liveCamera == 1)
			{
				if(camera0.GetEnabled() == true)
				{
					camera0.SetStream(false);
				}
				
				if(camera1.GetEnabled() == false)
				{
					camera1.SetStream(true);
				}
				
				if(joy.getRawButton(5))
				{
					screen.stream(screen.DrawRec(
							screen.DrawRec(camera1.getFeed(), new Point(200,50), new Point(250,150), new Scalar(255,255,255),1)
								,new Point(50,50) , new Point(100,150), new Scalar(255,255,255), 1));
				}
				else
				{
					screen.stream(camera1.getFeed());
				}
			}
		}
		
		camera0 = null;
		camera1 = null;
		screen = null;
	}
	
}
