
package team.sprocket.commands.shooter;

import team.sprocket.commands.CommandBase;

public class MoveArmToLowerPosition extends CommandBase {
    
    private double position = 4.38;
    private boolean done = false;
    
    public MoveArmToLowerPosition() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arm.moveArmTo(position);
        if(!(Math.abs(CommandBase.sensors.getArmPot() - position) > 0.015)){
            done = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
