//Contributors: HC

package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.OI;

public class ButtonDrive extends CommandBase {
    
    private double initialDistance, currentDistance;
    
    public ButtonDrive() {
        
    }

    protected void initialize() {
        //do nothing
    }

    protected void execute() {
        SmartDashboard.putNumber("Gyro Angle: ", sensors.getAngle());
        SmartDashboard.putNumber("Distance: ", sensors.getDistance());
        if(OI.jb_GamepadA.get()){
            differentialDriveTrain.allBack(0.5);
            return;
        }
        if(OI.jb_GamepadB.get()){
            differentialDriveTrain.turnClockwise();
            return;
        }
        if(OI.jb_GamepadX.get()){
            differentialDriveTrain.turnCounterclockwise();
            return;
        }
        if(OI.jb_GamepadY.get()){
            differentialDriveTrain.allForward(0.5);
            return;
        }
        if(OI.jb_LeftThrottle.get()){
            goDistance(36);
            return;
        }
        else differentialDriveTrain.stop();
    }
    
    private void goDistance(double inches){
        initialDistance = sensors.getDistance();
        currentDistance = initialDistance;
        while(initialDistance - currentDistance <= inches){
            differentialDriveTrain.allForward(0.5);
            currentDistance = sensors.getDistance();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        //run forever
    }

    // Called once after isFinished returns true
    protected void end() {
        differentialDriveTrain.stop();
    }

    protected void interrupted() {
        differentialDriveTrain.stop();
    }
}
