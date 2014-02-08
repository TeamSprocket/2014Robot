//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoAimSystem extends CommandBase {
    
    private double distance;
    private double currentArmAngle;
    private double targetArmAngle;
    private double harvesterAngle;
    private double deadband = 0.1;          //set deadband laterr
    
    public AutoAimSystem() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(SmartDashboard.getBoolean("AAS: ", true)){
            distance = sensors.getDistance();
            SmartDashboard.putString("Distance: ", new Double(sensors.getDistance()).toString());
            currentArmAngle = sensors.getShooterAngle();
            targetArmAngle = currentArmAngle;               //formula to be implemented
            moveShooter();
        }
        else{
            SmartDashboard.putString("Left Pot: ", new Double(sensors.getLeftPot()).toString());
            SmartDashboard.putString("Right Pot: ", new Double(sensors.getRightPot()).toString());
        }
    }
    
    private void moveShooter(){
        if(targetArmAngle > currentArmAngle){
            arm.armUp();                        //raise arm
        }
        if(targetArmAngle < currentArmAngle){
            arm.armDown();                     //lower arm
        }
        if(Math.abs(targetArmAngle - currentArmAngle) < deadband){
            arm.armStop();
        }
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
