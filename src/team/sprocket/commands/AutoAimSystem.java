//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoAimSystem extends CommandBase {
    
    private double distance;
    private double currentArmPosition;
    private double targetArmPosition;
    private boolean done;
    
    public AutoAimSystem() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        distance = sensors.getDistance();
        
        if(distance < 118 && distance > 60){
            arm.moveArmTo(4.28);
        }
        else if(distance > 118.05 && distance < 128){
            arm.moveArmTo(4.45);
        }
        done = true;
    }
    
    private void moveShooter(){
        arm.moveArmTo(targetArmPosition);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
