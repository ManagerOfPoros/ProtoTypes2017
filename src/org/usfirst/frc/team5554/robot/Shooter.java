package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor firstShooter;
	private Victor secondShooter;
	private Victor feeder;
	
	private double speed = 0.5;
	
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
			firstShooter.set(speed);
			secondShooter.set(-speed);
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
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	

}
