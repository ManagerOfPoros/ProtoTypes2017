package org.usfirst.frc.team5554.robot;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Motor extends Victor{

	private Encoder Enc;
	private double Velocity;
	
	/*constant parameters*/
	
	final double diameterOfShooterWheel = 7.6; //in cm
	final int maxRPM= 2655; // the maximum rpm of the shooter wheel 
	final double pulse = (diameterOfShooterWheel*3.14)/1440; // how much distance we travel in one pulse
	
	public Motor(int channel) {
		super(channel);
		Enc = new Encoder(RobotMap.ENCODER_SHOOTER_PORT_FIRST, RobotMap.ENCODER_SHOOTER_PORT_SECOND, false, CounterBase.EncodingType.k4X);
		Enc.setDistancePerPulse(pulse);
		Enc.reset();
	}
	
	public void checkVelocity()
	{
		
			Velocity = Enc.getRate();
		
	}
	
	public double getVelocity(){
		return Velocity;
	}
	
	public void setSpeed(double speed)
	{
		double desiredVelocity = speedToVelocity(speed);
		
		if (Velocity < desiredVelocity){
			this.set(velocityToSpeed(desiredVelocity-Velocity));
		}
		if (Velocity>desiredVelocity){
			this.set(velocityToSpeed(Velocity-desiredVelocity));
		}
		
	}
	
	public double velocityToSpeed(double velocity)                       // returns the velocity in pwm units from 0-1 
	{
		double maxVelocity = (maxRPM*3.14*diameterOfShooterWheel)/6000;
		double Speed = velocity/maxVelocity;
		
		return Speed;
	 }
	
	public double speedToVelocity(double speed)                       // returns the pwm in velocity units in m/s
	{
		double maxVelocity = (maxRPM*3.14*diameterOfShooterWheel)/6000;
		double desiredVelocity = speed*maxVelocity;
		
		return desiredVelocity;
	 }
	
	public void travelDistance(double givenDistance, double speed)
	{
		Enc.reset();
		if(Enc.getDistance() < givenDistance){
			Driver.Drive(speed);
		}
		else{
			Driver.Drive(0);
		}
	}
	
	
	
	

}
