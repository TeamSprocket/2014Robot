//Contributors: HC

package team.sprocket.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.commands.CommandBase;

public class LowerHarvester extends CommandBase {
    
    public LowerHarvester() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arm.harvesterDown();
        Timer.delay(0.68);
        arm.harvesterStop();
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
