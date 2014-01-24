

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccelerationMonitor extends CommandBase {
    
    private boolean stopped = true;
    private double lastAcceleration;
    private double currentAcceleration;
    private double sensitivity = 0.01;
    
    public AccelerationMonitor() {
        //requires(sensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        currentAcceleration = sensors.getAccelerationX();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lastAcceleration = currentAcceleration;
        currentAcceleration = sensors.getAccelerationX();
        stopped = Math.abs(currentAcceleration - lastAcceleration) < sensitivity;
    }
    
    public boolean isStopped(){
        return stopped;
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
