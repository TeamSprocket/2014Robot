//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoAimSystem extends CommandBase {
    
    private double distance;
    private double deadband = 0.02;
    private double straightenSpeed = 0.4;
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
        //straighten();
        
        distance = sensors.getPingArray()[2];
        
        if(distance < 95 && distance > 5){
            arm.moveArmTo(4.38);
        }
        else if(distance > 95.5 && distance < 128){
            arm.moveArmTo(4.52);
        }
        done = true;
    }
    
    private void straighten(){
        double left = sensors.getPingArray()[0];
        double right = sensors.getPingArray()[1];
        
        while(Math.abs(left - right) > deadband){
            if(left < right){
                differentialDriveTrain.turnCounterclockwise(straightenSpeed);
            }
            if(left > right){
                differentialDriveTrain.turnClockwise(straightenSpeed);
            }
        }
        differentialDriveTrain.stop();
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
