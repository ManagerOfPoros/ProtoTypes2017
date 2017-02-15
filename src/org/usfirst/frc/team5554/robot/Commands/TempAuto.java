package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.Driver;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TempAuto extends CommandGroup {
	
    public TempAuto(Driver d, double dis) {
    	super("Temp Auto");
    	addSequential(new DriveDistance(dis, d));
    }
}
