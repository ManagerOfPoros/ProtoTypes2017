package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.Driver;
import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_B extends CommandGroup {

    public Autonomous_B(Driver driver) {
    	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_BASELINE_FROM_START, driver));
    }
}
