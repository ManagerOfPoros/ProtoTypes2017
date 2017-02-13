package org.usfirst.frc.team5554.robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;

public class Motor extends Victor{

	private Encoder encoder;
	private PIDController controller;
	
	/*constant parameters*/
	
//	final double diameterOfShooterWheel = 15; //in cm
//	final double pi = Math.PI;
//	final int maxRPM= 2655; // the maximum rpm of the shooter wheel 
//	final int pulsesPerRevolution = 1440;
//	final double pulse = (diameterOfShooterWheel*pi)/(pulsesPerRevolution*100); // the distance we travel in one pulse
	
	
	public Motor(int port , Encoder enc) 
	{
		super(port);
		this.encoder = enc;
	}
	
	public void SetPIDType(PIDSourceType type)
	{
		encoder.setPIDSourceType(type);
	}
	
	public void SetPID(double p, double i, double d)
	{
		if(controller == null)
		{
			System.out.println("PID controller created");
			controller = new PIDController(p, i, d, encoder, this);
		}
		else
		{
			SetPid(p, i, d, 0);
		}
	}
	
	public void GoDistance(double distance)
	{
		SetPid(controller.getP(),controller.getI(),controller.getD(),0);
		controller.setSetpoint(distance);
		controller.enable();
	}
	
	public void MaintainSpeed(double speed)
	{
		SetPid(controller.getP(),controller.getI(),controller.getD(),speed);
		controller.setSetpoint(speed);
		controller.enable();
	}
	
	private void SetPid(double p,double i, double d, double f)
	{
		controller.setPID(p, i, d , f);
	}
	
	

}
