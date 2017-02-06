package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	/****************************************objects*******************************************/
	private Driver driver;
	private Shooter shooter;
	private Feeder feeder;
	private GearHolder gears;
	private CameraThread streamer;
	/****************************************Joysticks******************************************/
	private Joystick joy;
	/****************************************flags**********************************************/
	private boolean ignoreIncreaseSwitch = false;
	private boolean ignoreDecreaseSwitch = false;
	/*****************************************Autonomous******************************************/
	Command autonomousCommand;
	SendableChooser autoChooser;
	
	
	
	@Override
	public void robotInit() 
	{
		
		driver = new Driver(RobotMap.MOTOR_LEFT_ONE , RobotMap.MOTOR_LEFT_TWO, RobotMap.MOTOR_RIGHT_ONE, RobotMap.MOTOR_RIGHT_TWO );
		
		shooter = new Shooter(RobotMap.MOTOR_SHOOT_ONE,RobotMap.MOTOR_SHOOT_TWO, 6);
		
		//feeder = new Feeder(RobotMap.MOTOR_FEEDER);
		
		//gears = new GearHolder(0,2,4);
		//gears.SetLeds(true);
		
		joy = new Joystick(0);  
		
		streamer = new CameraThread(joy);
		streamer.start();
		
		//autoChooser = new SendableChooser();
		//autoChooser.addDefault("Default", Autonomous.Deafult);
		//autoChooser.addObject("Shooter", Autonomous.Shooter);
		//SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
	}

	@Override
	public void autonomousInit() 
	{
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit()
	{
		streamer.toSwitch = true;
	}

	@Override
	public void teleopPeriodic() 
	{
		
		/****************************************** Driving *********************************************/
		
		driver.Moving(joy.getRawAxis(1), joy.getRawAxis(2), joy.getRawAxis(3));
	
		/****************************************** Shooter *********************************************/
		
		shooter.shoot(joy.getRawButton(1));
		shooter.feed(joy.getRawButton(9));
		
		//increase speed button   // for tests 
    	if(joy.getRawButton(3) && ignoreIncreaseSwitch == false)
    	{
			ignoreIncreaseSwitch = true;
			
    		if(shooter.getSpeed() <= 1)
    		{
    			shooter.setSpeed(shooter.getSpeed()+0.01);
    		}
    	}
    	else if(!joy.getRawButton(3))
    	{
    		ignoreIncreaseSwitch = false;
    	}
    	
		//decrease speed button
    	if(joy.getRawButton(4) && ignoreDecreaseSwitch == false)
    	{
    		ignoreDecreaseSwitch = true;
    		
    		if(shooter.getSpeed() >= 0)
    		{
    			shooter.setSpeed(shooter.getSpeed()-0.01);
    		}

    	}
    	else if(!joy.getRawButton(4))
    	{
    		ignoreDecreaseSwitch = false;
    	}
    	
		/****************************************** Feeder *********************************************/
		
		//feeder.feed(joy.getRawButton(2));
    	
    	/***************************************** Gear Holder *****************************************/

		//gears.isGearIn();
    	
		
	}
	
	@Override
	public void disabledPeriodic()
	{
		streamer.toSwitch = false;
	}

	@Override
	public void testPeriodic() {
	}
}

