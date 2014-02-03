//Contributors: HC, BH

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;

public class Cock extends CommandBase {
    
    private boolean done = false;
    private final double resetTime = 0.25;          //how long to run the motor to reset (advance) rack
    
    public Cock() {
        
    }

    protected void initialize() {
    }

    protected void execute() {
        if(!sensors.cockLimit()){
            arm.withdrawRack();
        }
        else{
            arm.stopRack();
            latch();
            arm.advanceRack();
            Timer.delay(resetTime);
            arm.stopRack();
            done = true;
        }
    }
    
    private void latch(){
        while(!sensors.advanceLatchLimit()){
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
