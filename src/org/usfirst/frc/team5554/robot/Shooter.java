package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.PIDController;

public class Shooter 
{
	private Motor firstShooter;
	private Motor secondShooter;
	private Victor scrumble;
	 
	private double Speed = 1;               // pwm units
	private double Velocity;                // meters per second 
	

	public Shooter(int shooterFirstPort,int shooterSecondPort, int scrumblePort)
	{
		firstShooter = new Motor(shooterFirstPort);
		secondShooter = new Motor(shooterSecondPort);
		scrumble = new Victor(scrumblePort);
	}
	
	//shooter
	
	public void shoot(boolean toShoot)
	{
		if(toShoot )
		{
			firstShooter.set(Speed);
			secondShooter.set(Speed);
		}
		else
		{
			firstShooter.set(0);
			secondShooter.set(0);
		}	
	}

	public void calcVelocity(double distance)               //calculates the velocity and converts it to speed in pwm units (0-1)
	{
		
		/*constants*/
		final double heightOfBoiler = 2.47;
		final double angle = Math.toRadians(75); //THE DEGREES OF THE SHOOTER
				
		distance+=0.5; // so the ball will land in the middle
				
		/*the calculation*/
		double velocitySquared = (5*distance*distance)/((Math.tan(angle)-heightOfBoiler)*Math.cos(angle)*Math.cos(angle));
		Velocity = Math.sqrt(velocitySquared);
		double maxVelocity = (RobotMap.DIAMETER_Shooter_WHEEL*RobotMap.MAX_RPM_SHOOTER)/6000; //6000 seconds that is, to convert from rpm to velocity.
		Speed = Velocity/maxVelocity;
		
			
	}
		
			
	public void maintainSpeed()              // gets velocity in m/s
	{
		firstShooter.SetPID(1, 0.001, 2, 1);               //find the right f value
		secondShooter.SetPID(1, 0.001, 2, 1);
				
		firstShooter.SetPIDType(PIDSourceType.kDisplacement);
		secondShooter.SetPIDType(PIDSourceType.kDisplacement);
				
		this.firstShooter.GoSteady(Velocity);
		this.secondShooter.GoSteady(Velocity);
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
	
	

	/*methods that benefit us in tests on the shooter*/
	
	public void setSpeed(double Speed)
	{
		this.Speed = Speed;
	}
	
	public double getSpeed()
	{
		return this.Speed;
	}
	
	}
