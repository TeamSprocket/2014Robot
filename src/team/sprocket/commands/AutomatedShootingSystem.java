//Contributors: HC

package team.sprocket.commands;

public class AutomatedShootingSystem extends CommandBase {
    
    private double distance;
    private double threshold = 95;
    private double backwardPosition = 4.38;
    private double forwardPosition = 4.52;
    private boolean done;
    
    public AutomatedShootingSystem() {
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
        
        distance = sensors.getLeftPing();
        
        if(distance < threshold && distance > 20){
            arm.moveArmTo(backwardPosition);
        }
        else if(distance > threshold && distance < 128){
            arm.moveArmTo(forwardPosition);
        }
        
        done = true;
        /*else{
            done = true;
            return;
        }
        if((Math.abs(sensors.getArmPot() - forwardPosition) < 0.015) || (Math.abs(sensors.getArmPot() - backwardPosition) < 0.015)){
            done = true;
        }*/
    }
    
    /*private void straighten(){
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
    }*/

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
