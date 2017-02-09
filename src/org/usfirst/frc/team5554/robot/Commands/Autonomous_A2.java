package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_A2 extends CommandGroup {

    public Autonomous_A2() {
       addSequential(new DriveDistance(RobotMap.DISTANCE_TO_BASELINE_FROM_START + RobotMap.ROBOT_WIDTH));
       addSequential(new AutoSpin(-RobotMap.DEGREES_TO_TURN_TO_AIRSHIP));
       addSequential(new PlaceGear());
       addSequential(new AutoSpin(RobotMap.DEGREES_TO_TURN_TO_AIRSHIP));
       addSequential(new DriveDistance(RobotMap.DISTANCE_TO_HOPPER_FROM_BASELINE));
    }
}
