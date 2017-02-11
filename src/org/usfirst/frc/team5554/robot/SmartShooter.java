package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;

public class SmartShooter extends Thread {
	
	/*constant parameters*/
	final double diameterOfShooterWheel = 7.6; //in cm
	final int maxRPM= 2655; // the maximum rpm of the shooter wheel 
	
	public double calcVelocity(double distance){
		/*constants*/
		final double heightOfBoiler = 2.47;
		final double angle = Math.toRadians(75); //THE DEGREES OF THE SHOOTER
		
		distance+=0.5; // so the ball will land in the middle
		
		/*the calculation*/
		double velocitySquared = (5*distance*distance)/((Math.tan(angle)-heightOfBoiler)*Math.cos(angle)*Math.cos(angle));
		double velocity = Math.sqrt(velocitySquared);
		return velocity;
	}
	
	/*public double velocityToSpeed(double velocity)                       // returns the velocity in pwm units from 0-1 
	{
		double maxVelocity = (maxRPM*3.14*diameterOfShooterWheel)/6000;
		double Speed = velocity/maxVelocity;
		
		return Speed;
	 }
	
	public double neededCountChange(double velocity){
		
		double neededCountChange = velocity/0.12;
		return neededCountChange;
	}
	*/
}
