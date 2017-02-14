package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5554.robot.Driver;

public class DriveDistance extends Command
{
	int wantedValue;
	Driver driver;
	
	public DriveDistance(int _wantedValue, Driver _driver)
	{
		super("Drive Distance");
		wantedValue = _wantedValue;
		driver = _driver;
	}
	
	@Override
	public void initialize()
	{		
		//driver.
		System.out.println("We drove the distance");
	}
	
	@Override
	public boolean isFinished() 
	{
		
		return true;
	}

}
