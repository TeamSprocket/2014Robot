//Contributors: HC, BH

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.RobotMap;

public class Arm extends Subsystem {
    
    public void moveArmTo(double position){
        if(Math.abs(CommandBase.sensors.getArmPot() - position) > 0.015){
            if(CommandBase.sensors.getArmPot() < position){
                armUp();
            }
            else{
                armDown();
            }
        }
        else{
            armStop();
        }
    }
    
    public void armUp(){
        RobotMap.v_armActuator.set(-1);
    }
    
    public void armDown(){
        RobotMap.v_armActuator.set(1);
    }
    
    public void armUp(double speed){
        RobotMap.v_armActuator.set(-speed);
    }
    
    public void armDown(double speed){
        RobotMap.v_armActuator.set(speed);
    }
    
    public void armStop(){
        RobotMap.v_armActuator.set(0);
    }
    
    public void harvesterUp(){
        RobotMap.v_harvesterActuator.set(-1);
    }
    
    public void harvesterDown(){
        RobotMap.v_harvesterActuator.set(1);
    }
    
    public void harvesterStop(){
        RobotMap.v_harvesterActuator.set(0);
    }
    
    public void withdrawRack(){
        RobotMap.v_mainRackDriver.set(-0.8);
    }
    
    public void advanceRack(){
        RobotMap.v_mainRackDriver.set(1);
    }
    
    public void stopRack(){
        RobotMap.v_mainRackDriver.set(0);
    }
    
    public void advanceLatch(){
        RobotMap.v_triggerWindowMotor.set(1);
    }
    
    public void withdrawLatch(){
        RobotMap.v_triggerWindowMotor.set(-1);
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
    
    public void rollIn(double speed){
        RobotMap.v_collectorMotor.set(-speed);
    }
    
    public void rollOut(double speed){                      //Cattlebots, Roll Out!
        RobotMap.v_collectorMotor.set(speed);
    }
    
    public void rollStop(){
        RobotMap.v_collectorMotor.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
