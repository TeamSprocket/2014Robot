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
    
    //Digital IO Module # for Drive Train
    public static final int driveTrainDigitalModule         = 1;
    
    //Digital IO Module PWM Port # for Drive Train Motors
    public static final int frontLeftDriveTrainMotorPort    = 1;
    public static final int frontRightDriveTrainMotorPort   = 3;
    public static final int backLeftDriveTrainMotorPort     = 2;
    public static final int backRightDriveTrainMotorPort    = 4;
    
    //USB Port # for Interface Devices
    public static final int leftJoystickUSBPort             = 1;
    public static final int rightJoystickUSBPort            = 2;
    public static final int gamepadUSBPort                  = 3;
    
    //Port Information for Sensors
    public static final int accelerometerDigitalModule      = 1;
    
    //Static instatiations of all victors
    public static final Victor v_FrontLeftDriveTrain = new Victor(driveTrainDigitalModule, frontLeftDriveTrainMotorPort);
    public static final Victor v_FrontRightDriveTrain = new Victor(driveTrainDigitalModule, frontRightDriveTrainMotorPort);
    public static final Victor v_BackLeftDriveTrain = new Victor(driveTrainDigitalModule, backLeftDriveTrainMotorPort);
    public static final Victor v_BackRightDriveTrain = new Victor(driveTrainDigitalModule, backRightDriveTrainMotorPort);
    
    
}
