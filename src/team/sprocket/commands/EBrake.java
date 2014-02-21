//Contribtors: HC

package team.sprocket.commands;

import team.sprocket.main.CommandList;

//This is the command for self-regulating electronic braking system.
//Class will be under constant modification and construction.

public class EBrake extends CommandBase {
    
    private double initAcceleration;
    private double currentAcceleration;
    private double speed = 0.5;

    private double deadBand = 0;
    
    public EBrake() {
        requires(sensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initAcceleration = sensors.getAccelerationY();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!CommandList.accelerationMonitor.isStopped()){
            differentialDriveTrain.allForward(0.3);
        }
        else differentialDriveTrain.stop();
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
        //uninterruptable
    }
}
