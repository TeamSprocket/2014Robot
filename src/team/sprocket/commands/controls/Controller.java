//Contributors: HC

package team.sprocket.commands.controls;

import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;
import team.sprocket.main.OI;

public class Controller extends CommandBase {
    
    public Controller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
        //Harvest Listener
        if(OI.jb_LeftTrigger.get()){
            arm.rollIn();               //Harvest
        }
        else arm.rollStop();
        
        //Plant Listener
        if(OI.jb_RightTrigger.get()){
            arm.rollOut();              //Plant
        }
        else arm.rollStop();
        
        //Shoot Listener
        if(OI.jb_RightThrottle.get()){
            CommandList.shootSequence.start();
        }
        
        //arm up listener
        if(OI.jb_GamepadA.get()){
            arm.armDown();
        }
        else arm.armStop();
        
        //arm down listener
        if(OI.jb_GamepadY.get()){
            arm.armDown();
        }
        else arm.armDown();
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
