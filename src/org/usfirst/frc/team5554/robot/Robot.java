package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends IterativeRobot {

	private Driver driver;
	private Shooter shooter;
	//private Feeder feeder;
	
	private Joystick joy;
	
	@Override
	public void robotInit() 
	{
		driver = new Driver(RobotMap.MOTOR_LEFT , RobotMap.MOTOR_RIGHT );
		shooter = new Shooter(RobotMap.MOTOR_SHOOT, RobotMap.MOTOR_SHOOTER_FEEDER);
		//feeder = new Feeder(RobotMap.MOTOR_FEEDER);
		joy = new Joystick(0);
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopPeriodic() 
	{
		/****************************************** Driving *********************************************/
		
		driver.Moving(joy.getRawAxis(1), joy.getRawAxis(2), joy.getRawAxis(3));
	
		/****************************************** Shooter *********************************************/
		
		shooter.shoot(joy.getRawButton(1));
		shooter.feed(joy.getRawButton(2));
		
		/****************************************** Feeder *********************************************/
		
		//if(joy.getRawButton(2))
		//	feeder.feed();
		//else
		//	feeder.stopFeed();
		
	}

	@Override
	public void testPeriodic() {
	}
}

