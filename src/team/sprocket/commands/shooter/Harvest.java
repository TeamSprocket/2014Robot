//Contributors: TL, HC, BH

package team.sprocket.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Harvest extends CommandBase {
    
    public Harvest() {
        
    }

    protected void initialize() {
    
    }

    protected void execute() {
        arm.rollIn();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
