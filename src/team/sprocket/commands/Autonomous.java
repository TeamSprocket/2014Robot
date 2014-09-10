//hi
package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.main.CommandList;

public class Autonomous extends CommandBase {
    
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        CommandList.moveForward.start();
        while(CommandList.moveForward.isRunning()){}
        while(!sensors.harvesterLowerLimit()){
            arm.harvesterDown();
        }
        arm.harvesterStop();
        CommandList.shootSequence.start();
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
