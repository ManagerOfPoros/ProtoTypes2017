package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor firstShooter;
	private Victor secondShooter;
	private Victor feeder;
	
	public Shooter(int shooterFirstPort,int shooterSecondPort, int feederPort)
	{
		firstShooter = new Victor(shooterFirstPort);
		secondShooter = new Victor(shooterSecondPort);
		feeder = new Victor(feederPort);
	}
	
	//shooter
	public void shoot(boolean toShoot)
	{
		if(toShoot)
		{
			firstShooter.set(1);
			secondShooter.set(-1);
		}
		else
		{
			firstShooter.set(0);
			secondShooter.set(0);
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
