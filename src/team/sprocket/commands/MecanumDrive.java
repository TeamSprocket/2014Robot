//Contributors: HC

package team.sprocket.commands;

public class MecanumDrive extends CommandBase {
    
    double bearing;
    
    public MecanumDrive() {
        
    }
    
    protected void initialize() {
        bearing = sensors.getAngle();
    }

    protected void execute() {
        //this is where the real stuff happens!
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
