package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor shooter;
	private Victor feeder;
	
	public Shooter(int shooterPort, int feederPort)
	{
		shooter = new Victor(shooterPort);
		feeder = new Victor(feederPort);
	}
	
	public void shoot(boolean toShoot)
	{
		if(toShoot)
		{
			shooter.set(0.7);
		}
		else
		{
			shooter.set(0);
		}
	}
	
	public void feed(boolean toFeed)
	{
		if(toFeed)
		{
			feeder.set(-0.7);
		}
		else
		{
			feeder.set(0);
		}
	}
	

}
