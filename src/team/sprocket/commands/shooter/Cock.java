//Contributors: HC, BH

package team.sprocket.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.commands.CommandBase;

public class Cock extends CommandBase {
    
    private boolean done = false;
    private final double rackTime = 0.4;          //how long to run the motor to reset (advance) rack
    private final double lowerTime = 0.25;         //how long to run motor to lower harvester
            
    public Cock() {
        
    }

    protected void initialize() {
    }

    protected void execute() {
        while(!sensors.cockLimit()){
            unlatch();
            while(!sensors.cockLimit()){
                arm.withdrawRack();
            }
        }
        latch();
        //arm.stopRack();
        arm.advanceRack();
        Timer.delay(rackTime);
        arm.stopRack();
        //lowerHarvester();
        done = true;
    }
    
    private void lowerHarvester(){
        arm.harvesterDown();
        Timer.delay(lowerTime);
        arm.harvesterStop();
    }
    
    private void unlatch(){
        while(!sensors.withdrawLatchLimit()){
            arm.advanceLatch();
        }
        arm.stopLatch();
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
