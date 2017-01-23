package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Feeder {

	private Victor feeder;
	
	public Feeder(int feederPort)
	{
		feeder = new Victor(feederPort);
	}
	
	public void feed()
	{
		feeder.set(0.8);
	}
	
	public void stopFeed() // if not instructed, the feeder will continue to move
	{ 
		feeder.set(0);
	}
}
