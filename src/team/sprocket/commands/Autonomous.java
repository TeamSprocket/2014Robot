//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.image.Image;

public class Autonomous extends CommandBase {
    
    private Image image;
    
    public Autonomous() {
        requires(differentialDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        try{
            image = sensors.getImage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
