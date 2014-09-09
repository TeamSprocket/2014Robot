//Contributors: BH, HC, TL
// 2015

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.main.RobotMap;

public class MecanumDriveTrain extends Subsystem {
    
    private double frontLeftMag, frontRightMag, backLeftMag, backRightMag, direction, xComponent, yComponent;
    private final double deadBand   = .000000000000001;     //rounding compensation
    private final double r2d2       = Math.sqrt(2) / 2;     //root 2 denominator 2
    private double turn;
    
    public void translate(double magnitude, double bearing, double turn){
        direction = bearingToDirection(bearing);                                //calculate angle (in degrees) of magic triangle
        this.turn = turn;
        
        xComponent = magnitude * Math.cos(Math.toRadians(direction));           //calculate x component of translation vector
        yComponent = magnitude * Math.sin(Math.toRadians(direction));           //calculate y component of translation vector
        
        findMagnitudes();       //calculates needed speed for each motor
        turn();
        setVictors();           //sends values to Victors
        
    }
    
    public void stop(){
        RobotMap.v_FrontLeftDriveTrain.set(0);
        RobotMap.v_FrontRightDriveTrain.set(0);
        RobotMap.v_BackLeftDriveTrain.set(0);
        RobotMap.v_BackRightDriveTrain.set(0);
    }
    
    private void leftSideSet(double value){
        frontLeftMag = value;
        backLeftMag = value;
    }
    
    private void rightSideSet(double value){
        frontRightMag = value;
        backRightMag = value;
    }
    
    private double bearingToDirection(double bearing){
        if(bearing < 0){
            bearing += 360;
        }
        double d = 90 - bearing;                                                //we grew up watching ed, edd, 'n eddy
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
        RobotMap.v_FrontLeftDriveTrain.set(frontLeftMag);
        RobotMap.v_FrontRightDriveTrain.set(-1*frontRightMag);      //accounts for right side inverse
        RobotMap.v_BackLeftDriveTrain.set(backLeftMag);
        RobotMap.v_BackRightDriveTrain.set(-1*backRightMag);        //accounts for right side inverse
        refresh();
    }
    
    private void refresh(){      //refreshes magnitude values
        frontLeftMag = 0;
        frontRightMag = 0;
        backLeftMag = 0;
        backRightMag = 0;
    }
    
    public void turn(double speed){    //parameter determines whether turn CW or CCW
        if(speed < 0){
            SmartDashboard.putString("Turn", "Counter-Clockwise");
            rightSideSet(Math.abs(speed));
            leftSideSet(-Math.abs(speed));
        }
        if(speed > 0){
            SmartDashboard.putString("Turn", "Clockwise");
            rightSideSet(-Math.abs(speed));
            leftSideSet(Math.abs(speed));
        }
        setVictors();
    }
    
    private void turn(){
        turn *= 0.68;
        if(turn < -0.1){
            frontLeftMag -= Math.abs(turn);
            backLeftMag -= Math.abs(turn);
            frontRightMag += Math.abs(turn);
            backRightMag += Math.abs(turn);
        }
        if(turn > 0.1){
            frontLeftMag += Math.abs(turn);
            backLeftMag += Math.abs(turn);
            frontRightMag -= Math.abs(turn);
            backRightMag -= Math.abs(turn);
        }
    }

    public void initDefaultCommand() {
        //empty
    }
}
