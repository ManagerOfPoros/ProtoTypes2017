package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends IterativeRobot {

	private Driver driver;
	private Shooter shooter;
	private Feeder feeder;
	
	private Joystick joy;
	
	/******************************************flags*******************************************/
	private boolean ignoreIncreaseSwitch = false;
	private boolean ignoreDecreaseSwitch = false;
	/******************************************************************************************/
	
	@Override
	public void robotInit() 
	{
		driver = new Driver(RobotMap.MOTOR_LEFT , RobotMap.MOTOR_RIGHT );
		shooter = new Shooter(RobotMap.MOTOR_SHOOT_ONE,RobotMap.MOTOR_SHOOT_TWO, RobotMap.MOTOR_SHOOTER_FEEDER);
		feeder = new Feeder(RobotMap.MOTOR_FEEDER);
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
		shooter.feed(joy.getRawButton(9));
		
		/****************************************** Feeder *********************************************/
		
		feeder.feed(joy.getRawButton(2));
		
		//increase speed button
    	if(joy.getRawButton(3) && ignoreIncreaseSwitch == false)
    	{
			ignoreIncreaseSwitch = true;
			
    		if(shooter.getSpeed() != 1)
    			shooter.setSpeed(shooter.getSpeed()+0.05);
    	}
    	else if(!joy.getRawButton(3))
    	{
    		ignoreIncreaseSwitch = false;
    	}
    	
		//decrease speed button
    	if(joy.getRawButton(4) && ignoreDecreaseSwitch == false)
    	{
    		ignoreDecreaseSwitch = true;
    		
    		if(shooter.getSpeed() != 0)
    			shooter.setSpeed(shooter.getSpeed()-0.05);

    	}
    	else if(!joy.getRawButton(4))
    	{
    		ignoreDecreaseSwitch = false;
    	}
    	
    	/*********************************************************************************************/
    	
    	
    	

		
	}

	@Override
	public void testPeriodic() {
	}
}

