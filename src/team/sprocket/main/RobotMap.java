//Contributors: HC

package team.sprocket.main;

import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

//named HW class last year...not sure why (HC)
public class RobotMap {
    
    //Digital IO Module # for Arm Motors
    public static final int driveTrainDigitalModule         = 1;
    public static final int rackDriverDigitalModule         = 1;
    public static final int triggerWindowMotorDigitalModule = 1;
    public static final int collectorMotorDigitalModule     = 1;
    public static final int armActuatorDigitalModule        = 1;
    public static final int harvesterActuatorDigitalModule  = 1;
    
    //PWM Port # for Drive Train Motors
    public static final int frontLeftDriveTrainMotorPort    = 1;
    public static final int frontRightDriveTrainMotorPort   = 3;
    public static final int backLeftDriveTrainMotorPort     = 2;
    public static final int backRightDriveTrainMotorPort    = 4;
    
    //PWM Port # for Arm Motors
    public static final int rackDriverMotorPort             = 5;
    public static final int triggerWindowMotorPort          = 6;
    public static final int collectorMotorPort              = 7;
    public static final int armActuatorMotorPort            = 8;
    public static final int harvesterActuatorMotorPort      = 9;
    
    //USB Port # for Interface Devices
    public static final int leftJoystickUSBPort             = 1;
    public static final int rightJoystickUSBPort            = 2;
    public static final int gamepadUSBPort                  = 3;
    
    //Port Information for Sensors
    public static final int accelerometerDigitalModule      = 1;
    
    //Static instatiations of all DriveTrain victors
    public static final Victor v_FrontLeftDriveTrain = new Victor(driveTrainDigitalModule, frontLeftDriveTrainMotorPort);
    public static final Victor v_FrontRightDriveTrain = new Victor(driveTrainDigitalModule, frontRightDriveTrainMotorPort);
    public static final Victor v_BackLeftDriveTrain = new Victor(driveTrainDigitalModule, backLeftDriveTrainMotorPort);
    public static final Victor v_BackRightDriveTrain = new Victor(driveTrainDigitalModule, backRightDriveTrainMotorPort);
    
    //Static instantiations of all Arm victors
    public static final Victor v_mainRackDriver = new Victor(rackDriverDigitalModule, rackDriverMotorPort);
    public static final Victor v_triggerWindowMotor = new Victor(triggerWindowMotorDigitalModule, triggerWindowMotorPort);
    public static final Victor v_collectorMotor = new Victor(collectorMotorDigitalModule, collectorMotorPort);
    public static final Victor v_harvesterActuator = new Victor(harvesterActuatorDigitalModule, harvesterActuatorMotorPort);
    public static final Victor v_armActuator = new Victor(armActuatorDigitalModule, armActuatorMotorPort);
}
