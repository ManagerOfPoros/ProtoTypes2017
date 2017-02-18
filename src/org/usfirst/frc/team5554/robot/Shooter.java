package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Shooter 
{
	private Motor firstShooter;
	private Motor secondShooter;
	private Victor scrumble;
	private double Speed = 0.55;               // pwm units
	private double Velocity;      			// meters per second 

	public Shooter(int shooterFirstPort,int shooterSecondPort, int scrumblePort , Encoder shooterEncoder)
	{
		firstShooter = new Motor(shooterFirstPort);
		//secondShooter = new Motor(shooterSecondPort);
		scrumble = new Victor(scrumblePort);
		
		firstShooter.SetFeedbackDevice(shooterEncoder);
	}
	
	public void shoot(boolean toShoot)
	{
		if(toShoot )
		{
			firstShooter.set(Speed);
			//secondShooter.set(Speed);
		}
		else
		{
			firstShooter.set(0);
			//secondShooter.set(0);
		}	
	}
	
	public void distanceToSpeed(double distance){ //gets the distance from the camera.
		//given a distance, we'll put it in an equation that we get from excel and get the speed in pwm units.
	}
	
	public void maintainSpeed(double vel)              // gets velocity in m/s
	{
		firstShooter.SetPID(0.2, 0.2, 0, 1);               //find the right f value
		//secondShooter.SetPID(1, 0.001, 2, 1);
				
		firstShooter.SetPIDType(PIDSourceType.kRate);
		//secondShooter.SetPIDType(PIDSourceType.kDisplacement);
		
		this.firstShooter.GoSteady(vel);
		//this.secondShooter.GoSteady(Velocity);
	}
		
	public void scrumble(double toScrumble)
	{
		if (toScrumble > 0)
		{
			scrumble.set(1);
		}
		else
		{
			scrumble.set(0);
		}
	}
	
	public void autoShoot(){
		this.scrumble(1);
		this.shoot(true);
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
	
	public double get()
	{
		return firstShooter.getcontroller().getError();
	}
	
}
	
