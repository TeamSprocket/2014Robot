//Contributors: HC

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.sprocket.main.RobotMap;
import team.sprocket.commands.ButtonDrive;
import team.sprocket.commands.TankDrive;

public class DifferentialDriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private final Victor v_FrontLeftDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.frontLeftDriveTrainMotorPort);
    private final Victor v_FrontRightDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.frontRightDriveTrainMotorPort);
    private final Victor v_BackLeftDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.backLeftDriveTrainMotorPort);
    private final Victor v_BackRightDriveTrain = new Victor(RobotMap.driveTrainDigitalModule, RobotMap.backRightDriveTrainMotorPort);
    
    //sets left side of Drive Train going at certain speed
    public void setLeftSide(double speed){
        v_FrontLeftDriveTrain.set(speed);
        v_BackLeftDriveTrain.set(speed);
    }
    
    //sets left side of Drive Train full speed forward
    public void leftSideForward(){
        v_FrontLeftDriveTrain.set(1);
        v_BackLeftDriveTrain.set(1);
    }
    
    //sets left side of Drive Train full speed back
    public void leftSideBack(){
        v_FrontLeftDriveTrain.set(-1);
        v_BackLeftDriveTrain.set(-1);
    }
    
    //sets right side of Drive Train going at certain speed
    public void setRightSide(double speed){
        v_FrontRightDriveTrain.set(-1*speed);
        v_BackRightDriveTrain.set(-1*speed);
    }
    
    //sets right side of Drive Train full speed forward
    public void rightSideForward(){
        v_FrontRightDriveTrain.set(-1);
        v_BackRightDriveTrain.set(-1);
    }
    
    //sets right side of Drive Train full speed back
    public void rightSideBack(){
        v_FrontRightDriveTrain.set(1);
        v_BackRightDriveTrain.set(1);
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
