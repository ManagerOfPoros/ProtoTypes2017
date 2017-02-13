package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5554.robot.Driver;

public class DriveDistance extends Command
{
	int wantedValue;
	
	public DriveDistance(int _wantedValue)
	{
		super("Drive Distance");
		wantedValue = _wantedValue;
	}
	
	@Override
	public void initialize()
	{
		
		System.out.printf("We drove %d meters!", wantedValue);
	}
	
	@Override
	public boolean isFinished() 
	{
		
		return true;
	}

}
