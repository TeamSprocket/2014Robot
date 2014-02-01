//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootSequence extends CommandGroup {
    
    public ShootSequence() {

    }

    protected void initialize() {
    }

    protected void execute() {
        addSequential(new Shoot());
        addSequential(new Cock());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
