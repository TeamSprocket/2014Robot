//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*

I hereby invoke the spirit of innovation,
the essence of ingenuity, and the scent of


*/

public class MoveForward extends CommandBase {
    
    //private Image image;
    private boolean done;
    private double blobCount;
    private boolean finished;
    private boolean five;
    
    public MoveForward() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        done = false;
        finished = false;
        five = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
        differentialDriveTrain.allForward(0.5);
        Timer.delay(1.5);
        differentialDriveTrain.stop();
        Timer.delay(0.25);
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
