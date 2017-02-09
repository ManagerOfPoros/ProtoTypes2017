package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command
{

	public DriveDistance()
	{
		super("DriveDistance");
	}
	
	@Override
	public void initialize()
	{		
		//while(valuefromencoder != wanted value)
		//{
		//	driver.drive(speed);
		//}
		//
		//
		System.out.println("We drove the distance");
	}
	
	@Override
	public boolean isFinished() 
	{
		
		return true;
	}

}
