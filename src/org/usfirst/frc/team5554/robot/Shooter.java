package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor firstShooter;
	private Victor secondShooter;
	
	private double speed = 0.45;
	
	private Encoder upperEncoder;
	
	public Shooter(int shooterFirstPort, int shooterSecondPort, int upperEncoderPort, int lowwerEncoderPort)
	{
		firstShooter = new Victor(shooterFirstPort);
		secondShooter = new Victor(shooterSecondPort);
		upperEncoder = new Encoder(7, 8, false, Encoder.EncodingType.k4X);  
		
//		upperEncoder.setMaxPeriod(.1);
//		upperEncoder.setMinRate(10);
//		upperEncoder.setReverseDirection(true);
//		upperEncoder.setDistancePerPulse(5);
//		upperEncoder.setSamplesToAverage(7);
		upperEncoder.reset();
	}
	
	//shooter
	public void shoot(boolean toShoot)
	{
		if(toShoot)
		{
			//firstShooter.set(speed);
			secondShooter.set(speed);
			System.out.println(upperEncoder.get());
			

		}
		else
		{
			//firstShooter.set(0);
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
}
