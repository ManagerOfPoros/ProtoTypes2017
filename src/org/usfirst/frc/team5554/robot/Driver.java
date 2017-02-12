package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Driver
{
	private Victor left0;
	private Victor left1;
	private Victor right0;
	private Victor right1;
	public double speed = 0; //TODO: correct this with travelDistance();
	
	/**
	 * The constructor configurates the motors objects to certain ports
	 * @since 15/1/2017
	 * @param MOTOR_LEFT port for left motor
	 * @param MOTOR_RIGHT port for right motor
	 * @author Gil Meri
	 */
	public Driver(int motorLeftOne , int motorLeftTwo , int motorRightOne , int motorRightTwo) 
	{
		
		left0 = new Victor(motorLeftOne);
		left1 = new Victor(motorLeftTwo);
		right0 = new Victor(motorRightOne);
		right1 = new Victor(motorRightTwo);
		
	}
	
	/**
	 * This function is in charge of the movement of the robot with the joystick
	 * @since 15/1/2017
	 * @param y The value of the joystick's y axis
	 * @param z The value of the joystick's z axis
	 * @param slider The value of the joystick's slider axis
	 * @author Gil Meri
	 */
	public void moving(double y, double z, double slider) 
	{
		slider = (-slider+1)/2;
		
		double powerLeft = (y+z) * slider;
		double powerRight = (-y+z) * slider;
		
		if (powerLeft > 1)powerLeft=1;
		if (powerLeft < -1)powerLeft=-1;
		if (powerRight > 1)powerRight=1;
		if (powerRight < -1)powerRight=-1;
		
		this.left0.set(powerLeft);
		this.left1.set(powerLeft);
		this.right0.set(powerRight);
		this.right1.set(powerRight);
	}
	/**
	 * This function is in charge of moving the robot a given speed
	 * for autonomous actions
	 * @since 10/2/2017
	 * @param speed The needed speed to maintain during driving.
	 * @author Eyal Meltser
	 */
	public static void drive(double speed)
	{
		//here it will start the motors for the driver given a speed
		//to drive an exact distance
	}
	
	/**
	 * This function in charge of turning the robot a given angle
	 * for autonomous actions
	 * @since 10/2/2017
	 * @param angle The angle at which the robot must turn,
	 * positive for turning right and negative for turning left,
	 * in degrees.
	 * @author Eyal Meltser
	 */
	public void spin(double angle)
	{
		if(angle > 0){
			//then spin right
		}else if(angle < 0){
			angle *= -1;
			//then spin left
		}
	}
	
	/**
	 * This function in charge of moving the robot a given distance
	 * for autonomous actions
	 * @since 10/2/2017
	 * @param distance The distance at which the robot must go, in meters.
	 * @author Eyal Meltser
	 */
	public void travelDistance(int distance)
	{
		//do something
	}
}
