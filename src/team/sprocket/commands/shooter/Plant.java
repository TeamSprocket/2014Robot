//Contributors: TL, BH, HC

package team.sprocket.commands.shooter;

import team.sprocket.commands.CommandBase;

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
