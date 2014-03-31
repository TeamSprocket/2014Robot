//Contributors: HC, TN, BK

package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;
import team.sprocket.main.OI;

public class Controller extends CommandBase {
    
    private double deadband = 0.5;
    private double armspeed = 1;
    private double modifiedUpSpeed = 1;
    private double modifiedDownSpeed = 1;
    private double harvestspeed = 0.6;
    private double jy;
    private Timer tim = new Timer();
    
    public Controller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        OI.rx_RightPing.set(false);
        OI.rx_LeftPing.set(false);
        if(!sensors.advanceLatchLimit() && !getJoystickBottom()){
            CommandList.cock.start();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //arm.advanceLatch();
        jy = getJoystickY();
        modifiedUpSpeed = 1;
        modifiedDownSpeed = 1;
        
        SmartDashboard.putString("Pot Value: ", new Double(sensors.getArmPot()).toString());
        SmartDashboard.putBoolean("Cock Limit: ", sensors.cockLimit());
        SmartDashboard.putBoolean("Latch A Limit: ", sensors.advanceLatchLimit());
        SmartDashboard.putBoolean("Latch W Limit: ", sensors.withdrawLatchLimit());
        SmartDashboard.putBoolean("Harvester Limit: ", sensors.harvesterRaiseLimit());
        SmartDashboard.putBoolean("Arm Bottom Limit: ", sensors.armLowerLimit());
        SmartDashboard.putBoolean("Arm Top Limit: ", sensors.armRaiseLimit());
        SmartDashboard.putString("LP: ", new Double(sensors.getLeftPing()).toString());
        SmartDashboard.putString("BC: ", new Double(sensors.getBlobCount()).toString());
        
        
        //Harvest Listener
        /*if(getJoystickBottom() || getJoystickTop()){
            //harvester listener
            if(getJoystickBottom()){
                arm.rollIn(harvestspeed);               //Harvest
            }
            //plant listener
            if(getJoystickTop()){
                arm.rollOut(harvestspeed);              //Plant
            }
        }
        else arm.rollStop();*/
        
        if(getGamepadLT() || getGamepadRT()){
            //harvester listener
            if(getGamepadLT()){
                arm.rollIn(harvestspeed);               //Harvest
            }
            //plant listener
            if(getGamepadRT()){
                arm.rollOut(harvestspeed);              //Plant
            }
        }
        else arm.rollStop();
        
        /*if(getJoystickBottom() || getJoystickTop()){
            if(getJoystickBottom()){
                if(!sensors.harvesterRaiseLimit()){
                    arm.harvesterUp();
                }
            }
            if(getJoystickTop()){
                if(!CommandList.lowerHarvester.isRunning()){
                    CommandList.lowerHarvester.start();
                }
            }
        }
        else if(!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning()){
            arm.harvesterStop();
        }*/
            
        /*if(getJoystickTop() && !CommandList.automatedShootingSystem.isRunning()){
            CommandList.automatedShootingSystem.start();
        }*/
        
        //Shoot Listener
        if(getJoystick6() && getJoystick7() && !CommandList.shootSequence.isRunning() && !getJoystickBottom()){
            CommandList.shootSequence.start();
        }
        
        if(getJoystick6() && getJoystick7() && !CommandList.shootSequence.isRunning() && getJoystickBottom()){
            CommandList.shoot.start();
        }
        
        if(getJoystick4() && !CommandList.moveArmToLowerPosition.isRunning()){
            CommandList.moveArmToLowerPosition.start();
        }
        
        if(getJoystick5() && !CommandList.moveArmToUpperPosition.isRunning()){
            CommandList.moveArmToUpperPosition.start();
        }
        
        /*if(getJoystick8() && getJoystick9()){
            CommandList.shoot.cancel();
        }*/
        
        /*if((getJoystick10() || getJoystick11()) && !CommandList.shootSequence.isRunning() && !getJoystick6() && !getJoystick7()){
            if(getJoystick10()){
                arm.harvesterUp();
            }
            if(getJoystick11()){
                CommandList.lowerHarvester.start();
            }
        }
        else if(!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning() && !CommandList.lowerHarvester.isRunning()){
            arm.harvesterStop();
        }/*
        
        //manual rack operation
        /*if(getJoystick6() || getJoystick7()){
            if(getJoystick6()){
                arm.advanceRack();
            }
            if(getJoystick7()){
                if(!sensors.cockLimit()){
                    arm.withdrawRack();
                }
                else{
                    arm.stopRack();
                }
            }
            
        }
        else if(!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning()){
            arm.stopRack();
        }*/
        
        //manual latch operation
        /*if(getJoystick10() || getJoystick11()){
            if(getJoystick10()){
                arm.withdrawLatch();
            }
            if(getJoystick11()){
                arm.advanceLatch();
            }
        }
        else if(!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning() && !getJoystick5()){
            arm.stopLatch();
        }*/
        
        //arm listener
        if(getJoystickTrigger() && Math.abs(jy) > deadband){
            //arm up listener
            
            if(sensors.getArmPot() < 0.5){
                modifiedDownSpeed = 0.33;
            }
            
            if(sensors.getArmPot() > 4.5){
                modifiedUpSpeed = 0.33;
            }
            
            if(jy > 0){
                if(!sensors.armRaiseLimit()){
                    arm.armUp(modifiedUpSpeed);
                }
                else{
                    arm.armStop();
                }
            }
            //arm down listener
            if(jy < 0){
                if(!sensors.armLowerLimit()){
                    arm.armDown(modifiedDownSpeed);
                }
                else{
                    arm.armStop();
                }
            }
            
        }
        else arm.armStop();
        
        if(getJoystickTop() || getJoystickBottom()){
            if(getJoystickTop() && !sensors.harvesterLowerLimit()){
                arm.harvesterDown();
            }
            else if(getJoystickBottom() && !sensors.harvesterRaiseLimit()){
                arm.harvesterUp();
            }
            else arm.harvesterStop();
        }
        else arm.harvesterStop();
    }
    
    private boolean getGamepadA(){
        return OI.jb_GamepadA.get();
    }
    
    private boolean getGamepadY(){
        return OI.jb_GamepadY.get();
    }
    
    private boolean getGamepadLT(){
        return OI.jb_LeftGamepadTrigger.get();
    }
    
    private boolean getGamepadRT(){
        return OI.jb_RightGamepadTrigger.get();
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
