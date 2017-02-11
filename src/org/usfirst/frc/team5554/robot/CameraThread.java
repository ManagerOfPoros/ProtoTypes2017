package org.usfirst.frc.team5554.robot;

import org.opencv.core.Point;
import org.opencv.core.Scalar;

import edu.wpi.first.wpilibj.Joystick;

public class CameraThread extends Thread
{
	private Joystick joy;
	public boolean toSwitch = false;
	private boolean ignoreButton5 = false;
	private boolean ignoreButton9 = false;
	private boolean ignoreButton10 = false;
	private boolean ignoreButton11 = false;
	private boolean showRec = false;
	
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
			
	    	if(joy.getRawButton(5) && ignoreButton5 == false)
	    	{
	    		ignoreButton5 = true;
				
	    		if(showRec == false)
	    		{
	    			showRec = true;
	    		}
	    		else
	    		{
	    			showRec = false;
	    		}
	    		
	    	}
	    	else if(!joy.getRawButton(5))
	    	{
	    		ignoreButton5 = false;
	    	}
			
	    	if(showRec)
	    	{
	    		screen.stream(screen.DrawRec(
	    				screen.DrawRec(cameras.GetStream(), new Point(200,50),  new Point(250,150), new Scalar(255,255,255), 1)
    						,new Point(50,50) , new Point(100,150), new Scalar(255,255,255), 1));
	    	}
	    	else
	    	{
	    		screen.stream(cameras.GetStream());
	    	}

		}
	}
	
}
