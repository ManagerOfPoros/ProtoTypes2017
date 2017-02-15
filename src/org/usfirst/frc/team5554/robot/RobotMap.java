package org.usfirst.frc.team5554.robot;

public enum RobotMap {;

/*******************Motor Ports (PWM)*************************************************************************/
      public final static int MOTOR_LEFT_ONE = 0;
      public final static int MOTOR_LEFT_TWO = 1;
      public final static int MOTOR_RIGHT_ONE = 2;
      public final static int MOTOR_RIGHT_TWO = 3;
      public final static int MOTOR_FEEDER = 5;
      public final static int MOTOR_SCRUMBLE_PORT = 6;
      public final static int MOTOR_SHOOT_ONE = 8;
      public final static int MOTOR_SHOOT_TWO = 9;

/*******************Controller Ports**************************************************************************/
      public final static int DRIVER_JOYSTICK_PORT = 0;
      public final static int DRIVER_XBOXJOYSTICK_PORT = 1;
/*******************Control & Sensor Ports (DI/O)*************************************************************/
      public final static int ENCODER_SHOOTER_PORT_FIRST = 0;
      public final static int ENCODER_SHOOTER_PORT_SECOND = 1;
      public final static int ULTRASONIC_PORT_LEFT = 4;
      public final static int ULTRASONIC_PORT_RIGHT = 5; 
      public final static int LEDS_DRIVER_PORT = 6;
      
/*******************Field & Robot Distances In Centimeters****************************************************/
      public final static int DISTANCE_TO_AIRSHIP_FROM_SIDE = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_BASELINE_FROM_START = 237;
      public final static int DISTANCE_TO_AIRSHIP_FROM_BASELINE = 0; //TODO: Add a real measured value!
      public final static int DISTANCE_TO_HOPPER_FROM_BASELINE = 0; //TODO: Add a real measured value!
      public final static int ROBOT_WIDTH = 101;
      public final static int ROBOT_LENGTH = 91;
      public final static int ROBOT_HEIGHT = 60;
      
/*******************Constant Turning Angles In Degrees***************************************************/
      public final static int DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT = 0; //TODO: Add a real measured value!
      public final static int DEGREES_TO_TURN_TO_AIRSHIP = 0; //TODO: Add a real measured value!
      
      public final static int[] CAMERA_PORTS = {0,1,2};
/******************Encoder Values************************************************************************/
      public final static double PERIMETER_DRIVE_WHEEL = 0.1524 * Math.PI;
      public final static double PERIMETER_Shooter_WHEEL = 0.1524 * Math.PI;
      public final static int MAX_RPM_SHOOTER = 5840;
      public final static int PULSES_PER_REVELAION = 360;
 
}
