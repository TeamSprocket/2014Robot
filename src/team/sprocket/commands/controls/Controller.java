//Contributors: HC

package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;
import team.sprocket.main.OI;

public class Controller extends CommandBase {
    
    private double deadband = 0.5;
    private double armspeed = 0.5;
    private double harvestspeed = 0.5;
    private double jy;
    
    public Controller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //CommandList.cock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //arm.advanceLatch();
        jy = getJoystickY();
        SmartDashboard.putString("Distance: ", new Double(sensors.getDistance()).toString());
        SmartDashboard.putString("Pot Value: ", new Double(sensors.getArmPot()).toString());
        SmartDashboard.putBoolean("Cock Limit: ", sensors.cockLimit());
        SmartDashboard.putBoolean("Latch A Limit: ", sensors.advanceLatchLimit());
        SmartDashboard.putBoolean("Latch W Limit: ", sensors.withdrawLatchLimit());
        SmartDashboard.putBoolean("Harvester Limit: ", sensors.harvesterLimit());
        
        
        //Harvest Listener
        if(getJoystickBottom() || getJoystickTop()){
            //harvester listener
            if(getJoystickBottom()){
                arm.rollIn();               //Harvest
            }
            //plant listener
            if(getJoystickTop()){
                arm.rollOut();              //Plant
            }
        }
        else arm.rollStop();
        
        //manual rack operation
        /*if(getJoystickBottom() || getJoystickTop()){
            //rack withdraw
            if(getJoystickBottom()){
                if(!sensors.cockLimit()){
                    arm.withdrawRack();
                }
            }
            //rack advance
            if(getJoystickTop()){
                arm.advanceRack();
            }
        }
        else arm.stopRack();*/
        
        if(getJoystick4()){
            if(!CommandList.cock.isRunning()){
                CommandList.cock.start();
            }
        }
        
        /*if(getJoystick5()){
            arm.withdrawLatch();
        }
        else arm.stopLatch();*/
        
        //Shoot Listener
        if(getJoystick8() && getJoystick9()){
            if(!CommandList.shootSequence.isRunning()){
                CommandList.shoot.start();
            }
        }
        
        //manual latch operation
        if(getJoystick10() || getJoystick11()){
            if(getJoystick10()){
                arm.withdrawLatch();
            }
            if(getJoystick11()){
                arm.advanceLatch();
            }
        }
        else if(!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning()){
            arm.stopLatch();
        }
        
        //arm listener
        if(getJoystickTrigger() && Math.abs(jy) > deadband){
            //arm up listener
            if(jy > 0){
                if(sensors.getArmPot() < 0.516){
                    arm.armUp(armspeed);
                }
                else{
                    arm.armStop();
                }
            }
            //arm down listener
            if(jy < 0){
                if(sensors.getArmPot() > 0.00194){
                    arm.armDown(armspeed);
                }
                else{
                    arm.armStop();
                }
            }
            
        }
        else arm.armStop();
    }
    
    private double getJoystickY(){
        return OI.jy_LeftAttack.getAxis(Joystick.AxisType.kY);
    }
    
    private boolean getJoystickTrigger(){
        return OI.jb_LeftAttackTrigger.get();
    }
    
    private boolean getJoystickTop(){
        return OI.jb_LeftAttackTop.get();
    }
    
    private boolean getJoystickBottom(){
        return OI.jb_LeftAttackBottom.get();
    }
    
    private boolean getJoystick8(){
        return OI.jb_LeftAttack9.get();
    }
    
    private boolean getJoystick9(){
        return OI.jb_LeftAttack9.get();
    }
    
    private boolean getJoystick4(){
        return OI.jb_LeftAttack4.get();
    }
    
    private boolean getJoystick5(){
        return OI.jb_LeftAttack5.get();
    }
    
    private boolean getJoystick6(){
        return OI.jb_LeftAttack6.get();
    }
    
    private boolean getJoystick7(){
        return OI.jb_LeftAttack7.get();
    }
    
    private boolean getJoystick10(){
        return OI.jb_LeftAttack10.get();
    }
    
    private boolean getJoystick11(){
        return OI.jb_LeftAttack11.get();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
