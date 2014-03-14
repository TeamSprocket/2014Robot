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
        if(!sensors.harvesterLimit()){
            raiseHarvester();
        }
        if(sensors.harvesterLimit()){
            arm.harvesterStop();
            unlatch();
            if(sensors.withdrawLatchLimit()){
                arm.stopLatch();
                
                CommandList.lowerHarvester.start();
                done = true;
            }
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
