package org.usfirst.frc.team5554.robot;

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
		
		Camera camera0 = new Camera(0,640,480);
		Camera camera1 = new Camera(1,640,480);

		VideoBox screen = new VideoBox(640 , 480 , "Live Feed");


		while (!Thread.interrupted()) 
		{
			
			if(joy.getRawAxis(1) >= 0.125 || !toSwitch)
			{
				screen.stream(camera1.getFeed());
			}
			else
			{
				screen.stream(camera0.getFeed());
			}
		}
	}
}
