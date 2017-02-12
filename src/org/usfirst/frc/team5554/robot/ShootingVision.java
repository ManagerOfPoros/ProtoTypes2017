package org.usfirst.frc.team5554.robot;

/**
 * This class is a template for the Vision Tracking to aim at the boiler.
 * 
 * */
public class ShootingVision {
	
	ShootingVision(){
		
	}
	
	public void reciveInstruction(int index){
		if( (index < 5) && (index > 0) ){
			switch(index){
				case 0:
					System.out.println("All good!");
					break;
				case 1:
					System.out.println("Go Left!");
					break;
				case 2:
					System.out.println("Go Right!");
					break;
				case 3:
					System.out.println("Go Forward!");
					break;
				case 4:
					System.out.println("Go Back!");
					break;
			}
		}
	}
}
