package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.PIDController;;

public class Shooter 
{
	private Victor firstShooter;
	private Victor secondShooter;
	private Victor scrumble;
	private Victor duduShooter;
	 
	private double Speed = 0.6;
	

	public Shooter(int shooterFirstPort,int shooterSecondPort, int scrumblePort)
	{
		firstShooter = new Motor(shooterFirstPort);
		secondShooter = new Victor(shooterSecondPort);
		scrumble = new Victor(scrumblePort);
		//smartshooter = new SmartShooter();
		//	smartshooter.start();//start checking the countChange every second
		
		
		//PIDController = new PIDController(0, 0, 0, Enc, output)
		
		
		
	}
	
	//shooter
	
	
	public void shoot(boolean toShoot)
	{
		if(toShoot )
		{
			firstShooter.set(-Speed);
			secondShooter.set(-Speed);
			
			//secondShooter.checkVelocity();
			//System.out.println(secondShooter.getVelocity());*/
		}
		else
		{
			firstShooter.set(0);
			secondShooter.set(0);
		}	
	}

	
	
		/*public void smartShoot(double toShoot)
{
		 we need to know what is the speed needed to shoot and since we know it we know what the countChange needs to be
	
		if(toShoot>0){
		
			Speed = smartshooter.velocityToSpeed(smartshooter.calcVelocity(ultrasonic.getRangeMeters()));
			this.shoot(toShoot);
			
			
			
			if(smartshooter.getCountChange()< smartshooter.neededCountChange(smartshooter.calcVelocity(ultrasonic.getRangeMeters())){
				Speed+=0.05;
		}
		
	}
	}
	*/
		
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
