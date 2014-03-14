//Contributors: HC, BH

package team.sprocket.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;

public class Cock extends CommandBase {
    
    private boolean done = false;
    private final double rackTime = 0.4;           //how long to run the motor to reset (advance) rack
    //rme6ukvegqr
    
    public Cock() {
        
    }

    protected void initialize() {
        done = false;
    }

    protected void execute() {
        if(!sensors.cockLimit()){
            if(!sensors.withdrawLatchLimit()){
                unlatch();
            }
            if(sensors.withdrawLatchLimit()){
                arm.stopLatch();
                arm.withdrawRack();
            }
        }
        if(sensors.cockLimit()){
            arm.stopRack();
            if(sensors.withdrawLatchLimit()){
                arm.advanceLatch();
            }
            if(sensors.advanceLatchLimit()){
                arm.stopLatch();
                arm.advanceRack();
                Timer.delay(rackTime);
                arm.stopRack();
                done = true;
            }
        }
        
        
        
        /*while(!sensors.cockLimit()){
            unlatch();
            while(!sensors.cockLimit()){
                arm.withdrawRack();
            }
        }
        latch();
        arm.stopRack();
        arm.advanceRack();
        Timer.delay(rackTime);
        arm.stopRack();
        done = true;*/
    }
    
    private void unlatch(){
        arm.advanceLatch();
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
