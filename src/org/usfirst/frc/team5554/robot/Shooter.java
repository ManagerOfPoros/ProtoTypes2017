package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor firstShooter;
	private Victor secondShooter;
	private Victor scrumble;
	
	private double speed = 0.45;
	
	
	public Shooter(int shooterFirstPort, int shooterSecondPort, int scrumblePort)
	{
		firstShooter = new Victor(shooterFirstPort);
		secondShooter = new Victor(shooterSecondPort);
		scrumble = new Victor(scrumblePort);
	}
	
	//shooter
	public void shoot(double toShoot)
	{
		if(toShoot > 0)
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
	
	/*methods that benefit us in tests on the shooter*/
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	public void autoShoot()
	{
		
	}
	
	public void scrumble(double toScrumble)
	{
		if (toScrumble > 0)
		{
			scrumble.set(-1);
		}
		else
		{
			scrumble.set(0);
		}
	}
}
