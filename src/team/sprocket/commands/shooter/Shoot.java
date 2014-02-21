//Contributors: HC, BH

package team.sprocket.commands.shooter;

import team.sprocket.commands.CommandBase;

public class Shoot extends CommandBase {
    
    private boolean done = false;
    
    public Shoot() {

    }

    protected void initialize() {
        differentialDriveTrain.stop();
    }

    protected void execute() {
        raiseHarvester();
        unlatch();
        done = true;
    }
    
    private void raiseHarvester(){
        while(!sensors.harvesterLimit()){
            arm.harvesterUp();
        }
        arm.harvesterStop();
    }
    
    private void unlatch(){
        while(!sensors.withdrawLatchLimit()){
            arm.advanceLatch();
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
