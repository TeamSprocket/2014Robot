//Contributors: BH, HC, TL

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.sprocket.main.RobotMap;
import team.sprocket.commands.CommandBase;

public class MecanumDriveTrain extends Subsystem {
    
    private final Victor v_FrontLeftDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.frontLeftDriveTrainMotorPort);
    private final Victor v_FrontRightDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.frontRightDriveTrainMotorPort);
    private final Victor v_BackLeftDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.backLeftDriveTrainMotorPort);
    private final Victor v_BackRightDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.backRightDriveTrainMotorPort);
    
    private double frontLeftMag, frontRightMag, backLeftMag, backRightMag, direction, xComponent, yComponent;
    private final double deadBand   = .000000000000001;     //rounding compensation
    private final double r2d2       = Math.sqrt(2) / 2;     //root 2 denominator 2
    
    public void translate(double magnitude, double bearing){
        magnitude *= Math.sqrt(2);
        bearing %= 360;
        bearing -= CommandBase.sensors.getAngle();
        direction = bearingToDirection(bearing);                                //calculate angle (in degrees) of magic triangle
        
        xComponent = magnitude * Math.cos(Math.toRadians(direction));           //calculate x component of translation vector
        yComponent = magnitude * Math.sin(Math.toRadians(direction));           //calculate y component of translation vector
        
        findMagnitudes();       //calculates needed speed for each motor
        setVictors();           //sends values to Victors
        
    }
    
    private double bearingToDirection(double bearing){
        if(bearing < 0){                                                        //make sure direction is positive
            bearing += 360;                                                     //convert negative direction to positive direction
        }
        double d = bearing - 90;                                         //we grew up watching ed, edd, 'n eddy
        if(d < 0){                                                              //make sure direction is positive
            d += 360;                                                           //convert negative direction to positive direction
        }
        return d;
    }
    
    private void findMagnitudes(){
        if(Math.abs(xComponent) - Math.abs(yComponent) > deadBand){                             //if x is bigger than y
            frontLeftMag = backRightMag = r2d2 * (xComponent + yComponent);                     //"a"
            frontRightMag = backLeftMag = r2d2 * (yComponent - xComponent);                     //"b"
        }
        if(Math.abs(xComponent) - Math.abs(yComponent) < -1*deadBand){                          //if x is smaller than y
            frontLeftMag = backRightMag = r2d2 * (xComponent + yComponent);                     //"a"
            frontRightMag = backLeftMag = r2d2 * (yComponent - xComponent);                     //"b"
        }
        if(Math.abs(Math.abs(yComponent) - Math.abs(xComponent)) < deadBand){
            if((direction < 90 && direction > 0) || (direction > 180 && direction < 270)){      //if in Quadrant I or III
                frontLeftMag = backRightMag = r2d2 * (xComponent + yComponent);                 //"a"  
            }
            if((direction > 90 && direction < 180) || (direction > 270 && direction < 360)){    //if in Quadrant II or IV
                frontRightMag = backLeftMag = r2d2 * (yComponent - xComponent);                 //"b"
            }
        }
    }
    
    private void setVictors(){  //sets victors to certain speed
        v_FrontLeftDriveTrain.set(frontLeftMag);
        v_FrontRightDriveTrain.set(frontRightMag);
        v_BackLeftDriveTrain.set(backLeftMag);
        v_BackRightDriveTrain.set(backRightMag);
        refresh();
    }
    
    private void refresh(){      //refreshes magnitude values
        frontLeftMag = 0;
        frontRightMag = 0;
        backLeftMag = 0;
        backRightMag = 0;
    }
    
    public void turn(double speed, boolean dRoTA){    //parameter determines whether turn CW or CCW
        if(dRoTA){
            frontRightMag = speed;
            backLeftMag = -1 * speed;
        }
        if(!dRoTA){
            frontLeftMag = speed;
            backRightMag = -1 * speed;
        }
    }

    public void initDefaultCommand() {
        //empty
    }
}
