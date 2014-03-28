//Contributors: HC

package team.sprocket.commands.controls;

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
        if(OI.jb_Gamepad1A.get()){
            differentialDriveTrain.allBack(0.5);
            return;
        }
        if(OI.jb_Gamepad1B.get()){
            differentialDriveTrain.turnClockwise();
            return;
        }
        if(OI.jb_Gamepad1X.get()){
            differentialDriveTrain.turnCounterclockwise();
            return;
        }
        if(OI.jb_Gamepad1Y.get()){
            differentialDriveTrain.allForward(0.5);
            return;
        }
        else differentialDriveTrain.stop();
    }
    
    private void goDistance(double inches){
        initialDistance = sensors.getPingArray()[2];
        currentDistance = initialDistance;
        while(initialDistance - currentDistance <= inches){
            differentialDriveTrain.allForward(0.5);
            currentDistance = sensors.getPingArray()[2];
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
