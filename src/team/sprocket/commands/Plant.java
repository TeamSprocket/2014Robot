//Contributors: TL, BH, HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Plant extends CommandBase {
    
    public Plant() {
    }

    protected void initialize() {
    }

    protected void execute() {
        arm.rollOut();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
