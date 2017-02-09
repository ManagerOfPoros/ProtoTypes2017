package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_One extends CommandGroup
{
	public Autonomous_One()
	{
		addSequential(new DriveDistance());
		addSequential(new AutoShoot());
	}
}
