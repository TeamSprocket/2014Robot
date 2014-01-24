//Contributors: HC

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.sprocket.main.RobotMap;

public class DifferentialDriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //sets left side of Drive Train going at certain speed
    public void setLeftSide(double speed){
        RobotMap.v_FrontLeftDriveTrain.set(speed);
        RobotMap.v_BackLeftDriveTrain.set(speed);
    }
    
    //sets left side of Drive Train full speed forward
    public void leftSideForward(){
        RobotMap.v_FrontLeftDriveTrain.set(1);
        RobotMap.v_BackLeftDriveTrain.set(1);
    }
    
    //sets left side of Drive Train full speed back
    public void leftSideBack(){
        RobotMap.v_FrontLeftDriveTrain.set(-1);
        RobotMap.v_BackLeftDriveTrain.set(-1);
    }
    
    //sets right side of Drive Train going at certain speed
    public void setRightSide(double speed){
        RobotMap.v_FrontRightDriveTrain.set(-1*speed);
        RobotMap.v_BackRightDriveTrain.set(-1*speed);
    }
    
    //sets right side of Drive Train full speed forward
    public void rightSideForward(){
        RobotMap.v_FrontRightDriveTrain.set(-1);
        RobotMap.v_BackRightDriveTrain.set(-1);
    }
    
    //sets right side of Drive Train full speed back
    public void rightSideBack(){
        RobotMap.v_FrontRightDriveTrain.set(1);
        RobotMap.v_BackRightDriveTrain.set(1);
    }
    
    //sends Drive Train into forward motion at specified speed
    public void allForward(double speed){
        setLeftSide(speed);
        setRightSide(speed);
    }
    
    //sends Drive Train into forward motion at full speed
    public void allForward(){
        leftSideForward();
        rightSideForward();
    }
    
    //sends Drive Train into back motion at specified speed
    public void allBack(double speed){
        setLeftSide(-1*speed);
        setRightSide(-1*speed);
    }
    
    //sends Drive Train into back mtion at full speed
    public void allBack(){
        leftSideBack();
        rightSideBack();
    }
    
    //sends Drive Train spinning clockwise
    public void turnClockwise(){
        rightSideBack();
        leftSideForward();
    }
    
    //sends Drive Train spinning counterclockwise
    public void turnCounterclockwise(){
        leftSideBack();
        rightSideForward();
    }
    
    //stops Drive Train(){
    public void stop(){
        setRightSide(0);
        setLeftSide(0);
    }
    
    public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //nothing right now...
    }
}
