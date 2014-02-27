//Contributors: HC, BK

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.main.CommandList;

public class HotOrificeLocatingEntity extends CommandBase {
    
    private boolean done;
    private double blobCount;
    
    public HotOrificeLocatingEntity() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        blobCount = sensors.getBlobCount();
        
        if(blobCount != -1){
            if(blobCount > 1 || sensors.getTimer() > 5.25){
                SmartDashboard.putBoolean("Detect Hot: ", true);
                done = true;
            }
            else{
                SmartDashboard.putBoolean("Detect Hot: ", false);
            }
        }
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
