package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceGear extends Command {

    public PlaceGear() {
    	super("Place Gear");
    }

    @Override
    protected void initialize() {
    	System.out.println("The robot is ready to place the gear man!");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
