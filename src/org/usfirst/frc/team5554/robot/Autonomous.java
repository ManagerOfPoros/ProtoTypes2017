package org.usfirst.frc.team5554.robot;

public enum Autonomous
{
	Deafult("Default"),
	Shooter("Shooter");
	
	private Autonomous(String autonomous)
	{
		Shooter shooter = new Shooter(2,4,5);
		
		switch(autonomous)
		{
			case "Default":
			{
				System.out.println("default");
			}
			case "Shooter":
			{
				System.out.println("shooter");
			}
		}
	}
}
