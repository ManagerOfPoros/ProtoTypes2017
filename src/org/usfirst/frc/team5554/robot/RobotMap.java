package org.usfirst.frc.team5554.robot;

public enum RobotMap {;

/*******************Motor Ports**************************************************************************/
      public final static int MOTOR_LEFT_ONE = 0;
      public final static int MOTOR_LEFT_TWO = 1;
      public final static int MOTOR_RIGHT_ONE = 2;
      public final static int MOTOR_RIGHT_TWO = 3;
      public final static int MOTOR_FEEDER = 8;
      public final static int MOTOR_SHOOT_ONE = 5;
      public final static int MOTOR_SHOOT_TWO = 4;
      public final static int SCRUMBLE_PORT = 6;
      //public final static int MOTOR_SHOOTER_FEEDER = 9;
/*******************Control & Sensor Ports**************************************************************************/
      public final static int DRIVER_JOYSTICK_PORT = 0;
      public final static int DRIVER_XBOXJOYSTICK_PORT = 1;
      
/*******************Field & Robot Distances In Centimeters***********************************************/
      public final static int DISTANCE_TO_AIRSHIP_FROM_MIDDLE = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_AIRSHIP_FROM_SIDE = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_BASELINE_FROM_START = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_AIRSHIP_FROM_BASELINE = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_HOPPER_FROM_BASELINE = 0; //TODO: Add a real measured value!
      public final static int ROBOT_WIDTH = 101; //Centimeters
      public final static int ROBOT_LENGTH = 91; //Centimeters
      public final static int ROBOT_HEIGHT = 60; //Centimeters
/*******************Constant Turning Angles In Degrees***************************************************/
      public final static int DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT = 0; //TODO: Add a real measured value!
      public final static int DEGREES_TO_TURN_TO_AIRSHIP = 0; //TODO: Add a real measured value!
      
      public final static int[] CAMERA_PORTS = {0,1,2};
 
}
