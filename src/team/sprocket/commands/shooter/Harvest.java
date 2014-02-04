//Contributors: TL, HC, BH

package team.sprocket.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;

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
