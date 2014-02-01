//Contributors: HC, BH

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.sprocket.main.RobotMap;

public class Arm extends Subsystem {
    
    public void withdrawRack(){
        RobotMap.v_mainRackDriver.set(-1);
    }
    
    public void advanceRack(){
        RobotMap.v_mainRackDriver.set(1);
    }
    
    public void stopRack(){
        RobotMap.v_mainRackDriver.set(0);
    }
    
    public void withdrawLatch(){
        RobotMap.v_triggerWindowMotor.set(-1);
    }
    
    public void advanceLatch(){
        RobotMap.v_triggerWindowMotor.set(1);
    }
    
    public void stopLatch(){
        RobotMap.v_triggerWindowMotor.set(0);
    }
    
    public void rollIn(){
        RobotMap.v_collectorMotor.set(-1);
    }
    
    public void rollOut(){                      //Cattlebots, Roll Out!
        RobotMap.v_collectorMotor.set(1);
    }
    
    public void rollStop(){
        RobotMap.v_collectorMotor.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
