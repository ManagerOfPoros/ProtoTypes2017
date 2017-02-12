package org.usfirst.frc.team5554.robot;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Motor extends Victor{

	private Encoder Enc;
	private double currentVelocity;
	
	/*constant parameters*/
	
	final double diameterOfShooterWheel = 15; //in cm
	final double pi = Math.PI;
	final int maxRPM= 2655; // the maximum rpm of the shooter wheel 
	final int pulsesPerRevolution = 1440;
	final double pulse = (diameterOfShooterWheel*pi)/(pulsesPerRevolution*100); // the distance we travel in one pulse
	
	int count = 0;
	long firstCount;
	long secondCount;
	//long countChange ;
	
	public Motor(int channel) {
		super(channel);
		//Enc = new Encoder(RobotMap.ENCODER_SHOOTER_PORT_FIRST, RobotMap.ENCODER_SHOOTER_PORT_SECOND, false, CounterBase.EncodingType.k4X);
		//Enc.setDistancePerPulse(pulse);
		//Enc.reset();
	//	currentVelocity = 0;
	}
	
	public void checkVelocity(boolean toCheck)     
	{		
		if(toCheck){
			
		if(count==0)
			Enc.reset();
			if(count == 1){
			currentVelocity = Enc.getDistance()/0.02;
			count=0;
		}		
		else{
			count++;
		}
	}
		else
			count=0;
	}

	
	public void checkVelocity(){ 						// 	The	getRate function returns the velocity;
		currentVelocity=Enc.getRate();
	}
	
	public double getVelocity(){
		return currentVelocity;
	}
	
	public double getDistance(){
		return Enc.getDistance();
	}
	public int getCount(){
		return Enc.get();
	}
	
	public void setAndMaintain(double speed)               
	{
		double desiredVelocity = speedToVelocity(speed);
		
		if (currentVelocity < desiredVelocity){
			this.set(velocityToSpeed(desiredVelocity-currentVelocity));
		}
		if (currentVelocity>desiredVelocity){
			this.set(velocityToSpeed(currentVelocity-desiredVelocity));
		}
		
	}
	
	public double velocityToSpeed(double velocity)                       // returns the velocity in pwm units from 0-1 
	{
		double maxVelocity = (maxRPM*pi*diameterOfShooterWheel)/6000;
		double Speed = velocity/maxVelocity;
		
		return Speed;
	 }
	
	public double speedToVelocity(double speed)                       // returns the pwm in velocity units in m/s
	{
		double maxVelocity = (maxRPM*pi*diameterOfShooterWheel)/6000;
		double desiredVelocity = speed*maxVelocity;
		
		return desiredVelocity;
	 }
	
	/*public void travelDistance(double givenDistance, double speed)
	{
		Enc.reset();
		if(Enc.getDistance() < givenDistance){
			Driver.Drive(speed);
		}
		else{
			Driver.Drive(0);
		}
	}
	*/
	
	
	

}
