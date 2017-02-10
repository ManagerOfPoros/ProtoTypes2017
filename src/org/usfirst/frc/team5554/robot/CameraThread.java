package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Joystick;

public class CameraThread extends Thread
{
	private Joystick joy;
	public boolean toSwitch = false;
	private boolean ignoreButton9 = false;
	private boolean ignoreButton10 = false;
	private boolean ignoreButton11 = false;
	
	public CameraThread(Joystick operator)
	{
		joy = operator;
	}
	
	@Override
	
	public void run()
	{		
		CameraHandler cameras = new CameraHandler(RobotMap.CAMERA_PORTS,320,240);

		VideoBox screen = new VideoBox(320 , 240 , "Live Feed");

		int liveCamera = 0;
		
		cameras.SetStreamer(liveCamera);
		
		while (!Thread.interrupted()) 
		{
			if(toSwitch)
			{
		    	if(joy.getRawButton(9) && ignoreButton9 == false)
		    	{
		    		ignoreButton9 = true;
					
		    		if(liveCamera != 0)
		    		{
		    			liveCamera = 0;
		    		}
		    	}
		    	else if(!joy.getRawButton(9))
		    	{
		    		ignoreButton9 = false;
		    	}
		    	
		    	if(joy.getRawButton(10) && ignoreButton10 == false)
		    	{
		    		ignoreButton10 = true;
					
		    		if(liveCamera != 1)
		    		{
		    			liveCamera = 1;
		    		}
		    	}
		    	else if(!joy.getRawButton(10))
		    	{
		    		ignoreButton10 = false;
		    	}
		    	if(joy.getRawButton(11) && ignoreButton11 == false)
		    	{
		    		ignoreButton11 = true;
					
		    		if(liveCamera != 2)
		    		{
		    			liveCamera = 2;
		    		}
		    	}
		    	else if(!joy.getRawButton(11))
		    	{
		    		ignoreButton11 = false;
		    	}
			}
			else
			{
				liveCamera = 0;
			}
			
			cameras.SetStreamer(liveCamera);
			screen.stream(cameras.GetStream());
		}
	}
	
}
