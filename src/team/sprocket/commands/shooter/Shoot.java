//Contributors: HC, BH

package team.sprocket.commands.shooter;

import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;

public class Shoot extends CommandBase {
    
    private boolean done = false;
    
    public Shoot() {
        
    }

    protected void initialize() {
        done = false;
    }

    protected void execute() {
        if(sensors.advanceLatchLimit()){
            unlatch();
        }
        if(sensors.withdrawLatchLimit()){
            arm.stopLatch();
            done = true;
        }
        
    }
    
    private void raiseHarvester(){
        arm.harvesterUp();
    }
    
    private void unlatch(){
        arm.advanceLatch();
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
