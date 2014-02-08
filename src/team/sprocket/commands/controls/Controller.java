//Contributors: HC

package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;
import team.sprocket.main.OI;

public class Controller extends CommandBase {
    
    private double deadband = 0.5;
    private double armspeed = 0.5;
    private double harvestspeed = 0.5;
    private double jy;
    
    public Controller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        jy = getJoystickY();
        SmartDashboard.putString("Distance: ", new Double(sensors.getDistance()).toString());
        
        //Harvest Listener
        if(getJoystickBottom()){
            arm.rollIn();               //Harvest
        }
        else arm.rollStop();
        
        //Plant Listener
        if(getJoystickTop()){
            arm.rollOut();              //Plant
        }
        else arm.rollStop();
        
        //Shoot Listener
        if(getJoystickTrigger() && getJoystickTop() && getJoystickBottom()){
            CommandList.shootSequence.start();
        }
        
        //arm up listener
        if(getJoystickTrigger() && Math.abs(jy) > deadband && jy < 0){
            arm.armDown(armspeed);
        }
        else arm.armStop();
        
        //arm down listener
        if(getJoystickTrigger() && Math.abs(jy) > deadband && jy > 0){
            arm.armDown(armspeed);
        }
        else arm.armDown();
    }
    
    private double getJoystickY(){
        return OI.jy_LeftAttack.getAxis(Joystick.AxisType.kY);
    }
    
    private boolean getJoystickTrigger(){
        return OI.jb_LeftAttackTrigger.get();
    }
    
    private boolean getJoystickTop(){
        return OI.jb_LeftAttackTop.get();
    }
    
    private boolean getJoystickBottom(){
        return OI.jb_LeftAttackBottom.get();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
