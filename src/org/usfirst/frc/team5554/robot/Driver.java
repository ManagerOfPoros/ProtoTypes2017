package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Driver
{
	private Talon left;
	private Victor right;
	//private Victor omni;
	
	/**
	 * The constructor configurates the motors objects to certain ports
	 * @since 15/1/2017
	 * @param MOTOR_LEFT port for left motor
	 * @param MOTOR_RIGHT port for right motor
	 * Author: Gil Meri
	 */
	public Driver(int MOTOR_LEFT, int MOTOR_RIGHT) //int OMNI
	{
		
		left = new Talon(MOTOR_LEFT);
		right = new Victor(MOTOR_RIGHT);
		//omni = new Victor(OMNI);
		
	}
	
	/**
	 * This function incharge of the movement of the robot with the joystick
	 * @since 15/1/2017
	 * @param y The value of the joystick's y axis
	 * @param z The value of the joystick's z axis
	 * @param slider The value of the joystick's slider axis
	 * Author: Gil Meri
	 */
	public void Moving (double y, double z, double slider) //double x
	{
		slider = (-slider+1)/2;
		
		double powerLeft = (y-z) * slider;
		double powerRight = (y+z) * slider;
		
		if (powerLeft > 1)powerLeft=1;
		if (powerLeft < -1)powerLeft=-1;
		if (powerRight > 1)powerRight=1;
		if (powerRight < -1)powerRight=-1;
		
		this.left.set(-powerLeft+(powerLeft/2));
		this.right.set(powerRight);
		//this.omni.set(x*(slider));  
		
		
	}
}
