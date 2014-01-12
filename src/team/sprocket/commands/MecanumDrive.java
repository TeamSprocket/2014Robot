//Contributors: HC, BH, TL

package team.sprocket.commands;

public class MecanumDrive extends CommandBase {
    
    private double bearing;
    
    public MecanumDrive() {
        requires(mecanumDriveTrain);
    }
    
    protected void initialize() {
        bearing = sensors.getAngle();
    }

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
