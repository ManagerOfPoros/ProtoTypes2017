package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.robot.Commands.*;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
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
	@SuppressWarnings("unused")
	private GearHolder gears;
	private CameraThread streamer;
	/****************************************Joysticks******************************************/
	private Joystick joy;
	private Joystick xbox;
	/****************************************flags**********************************************/
	private boolean ignoreIncreaseSwitch = false;
	private boolean ignoreDecreaseSwitch = false;
	/*****************************************Autonomous******************************************/
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	/********************************************************************************************/
	private double sum = 0.0;
	private double counter = 0;
	
	Encoder encoder;
	
	@Override
	public void robotInit() 
	{
		encoder = new Encoder(6,7,true,CounterBase.EncodingType.k4X);
		encoder.setDistancePerPulse(RobotMap.DIAMETER_DRIVE_WHEEL/RobotMap.PULSES_PER_REVELAION);
		/***********************************************************************************************************/
		driver = new Driver(RobotMap.MOTOR_LEFT_ONE , RobotMap.MOTOR_LEFT_TWO, RobotMap.MOTOR_RIGHT_ONE, RobotMap.MOTOR_RIGHT_TWO,null,encoder );
		
		shooter = new Shooter(RobotMap.MOTOR_SHOOT_ONE,RobotMap.MOTOR_SHOOT_TWO, RobotMap.MOTOR_SCRUMBLE_PORT);
		
		feeder = new Feeder(RobotMap.MOTOR_FEEDER);
		
		//gears = new GearHolder(0,2,4);
		//gears.SetLeds(true);
		
		joy = new Joystick(RobotMap.DRIVER_JOYSTICK_PORT);
		xbox = new Joystick(RobotMap.DRIVER_XBOXJOYSTICK_PORT);  
		
		streamer = new CameraThread(joy);
		/*streamer.start();*/
		
		/***********************************Autonomous Options***********************************************/
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Empty", new Autonomous_Empty());
		autoChooser.addObject("A1", new Autonomous_A1());
		autoChooser.addObject("A2", new Autonomous_A2());
		autoChooser.addObject("B", new Autonomous_B());
		autoChooser.addObject("C1", new Autonomous_C1());
		autoChooser.addObject("C2", new Autonomous_C2());
		autoChooser.addObject("C3", new Autonomous_C3());
		autoChooser.addObject("C4", new Autonomous_C4());
		SmartDashboard.putData("Autonomous" , autoChooser);
		/****************************************************************************************************/
		
		
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
		encoder.reset();
		//driver.DriveSteady(-0.5);
		
	}

	@Override
	public void teleopPeriodic() 
	{
		
		/****************************************** Driving *********************************************/
		
		driver.Moving(joy.getRawAxis(1), joy.getRawAxis(2), joy.getRawAxis(3));
	
		/****************************************** Shooter *********************************************/
			shooter.shoot(joy.getRawButton(1));
			
//			counter++;
//			sum =+ encoder.getRate();
//			System.out.println(encoder.getRate());
										
		
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
    	
    	/****************************************** Scrumble *******************************************/
    	//shooter.scrumble(xbox.getRawAxis(2));
    	
		/****************************************** Feeder *********************************************/
		
		//feeder.feed(joy.getRawButton(1));
    	
    	/***************************************** Gear Holder *****************************************/

		//gears.isGearIn();
    	
		
	}
	
	@Override
	public void disabledPeriodic()
	{
		streamer.toSwitch = false;
		System.out.println("The average speed is: " + (sum/counter));
	}

	@Override
	public void testPeriodic() 
	{
	}
	
}

