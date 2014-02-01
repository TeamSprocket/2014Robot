//Contributors: HC, BH

package team.sprocket.commands;

public class Shoot extends CommandBase {
    
    private boolean done = false;
    
    public Shoot() {

    }

    protected void initialize() {
    }

    protected void execute() {
        unlatch();
        done = true;
    }
    
    private void unlatch(){
        while(!sensors.withdrawLatchLimit()){
            arm.withdrawLatch();
        }
        arm.stopLatch();
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
