//Contributors: HC, TN, BK

package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.CommandList;
import team.sprocket.main.OI;

public class Controller2 extends CommandBase {
    
    private double deadband = 0.5;
    private double armspeed = 1;
    private double modifiedArmspeed = 1;
    private double harvestspeed = 0.6;
    
    public Controller2() {
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
        modifiedArmspeed = 1;
        
        SmartDashboard.putString("Pot Value: ", new Double(sensors.getArmPot()).toString());
        SmartDashboard.putBoolean("Cock Limit: ", sensors.cockLimit());
        SmartDashboard.putBoolean("Latch A Limit: ", sensors.advanceLatchLimit());
        SmartDashboard.putBoolean("Latch W Limit: ", sensors.withdrawLatchLimit());
        SmartDashboard.putBoolean("Harvester Raise Limit: ", sensors.harvesterRaiseLimit());
        SmartDashboard.putBoolean("Harvester Lower Limit: ", sensors.harvesterLowerLimit());
        SmartDashboard.putBoolean("Arm Bottom Limit: ", sensors.armLowerLimit());
        SmartDashboard.putBoolean("Arm Top Limit: ", sensors.armRaiseLimit());
        SmartDashboard.putString("LP: ", new Double(sensors.getLeftPing()).toString());
        SmartDashboard.putString("BC: ", new Double(sensors.getBlobCount()).toString());
        
        if(getGamepad1LT() || getGamepad1RT()){
            //harvester listener
            if(getGamepad1LT()){
                arm.rollIn(harvestspeed);               //Harvest
            }
            //plant listener
            if(getGamepad1RT()){
                arm.rollOut(harvestspeed);              //Plant
            }
        }
        else{
            arm.rollStop();
        }
        
        //Shoot Listener
        if(getGamepad2LT() && getGamepad2RT() && !CommandList.shootSequence.isRunning() && !getGamepad2B()){
            CommandList.shootSequence.start();
        }
        
        if(getGamepad2LT() && getGamepad2RT() && !CommandList.shootSequence.isRunning() && getGamepad2B()){
            CommandList.shoot.start();
        }
        
        if(getJoystick4() && !CommandList.moveArmToLowerPosition.isRunning()){
            CommandList.moveArmToLowerPosition.start();
        }
        
        if(getJoystick5() && !CommandList.moveArmToUpperPosition.isRunning()){
            CommandList.moveArmToUpperPosition.start();
        }
        
        //arm listener
        if(Math.abs(getGamepad2DVertical()) > deadband){
            //arm up listener
            
            if(sensors.getArmPot() < 0.75){
                modifiedArmspeed = 0.33;
            }
            
            if(getGamepad2DVertical() > 0){
                if(!sensors.armRaiseLimit()){
                    arm.armUp(armspeed);
                }
                else{
                    arm.armStop();
                }
            }
            //arm down listener
            if(getGamepad2DVertical() < 0){
                if(!sensors.armLowerLimit()){
                    arm.armDown(modifiedArmspeed);
                }
                else{
                    arm.armStop();
                }
            }
            
        }
        else{
            arm.armStop();
        }
        
        if(getGamepad2Y() || getGamepad2A()){
            if(getGamepad2Y() && !sensors.harvesterLowerLimit()){
                arm.harvesterDown();
            }
            if(getGamepad2A() && !sensors.harvesterRaiseLimit()){
                arm.harvesterUp();
            }
        }
        else{
            arm.harvesterStop();
        }
    }
    
    private boolean getGamepad1LT(){
        return OI.jb_LeftGamepad1Trigger.get();
    }
    
    private boolean getGamepad1RT(){
        return OI.jb_RightGamepad1Trigger.get();
    }
    
    private boolean getGamepad2LT(){
        return OI.jb_LeftGamepad2Trigger.get();
    }
    
    private boolean getGamepad2RT(){
        return OI.jb_RightGamepad2Trigger.get();
    }
    
    private boolean getGamepad2A(){
        return OI.jb_Gamepad2A.get();
    }
    
    private boolean getGamepad2B(){
        return OI.jb_Gamepad2B.get();
    }
    
    private boolean getGamepad2X(){
        return OI.jb_Gamepad2X.get();
    }
    
    private boolean getGamepad2Y(){
        return OI.jb_Gamepad2Y.get();
    }
    
    private double getGamepad2DVertical(){
        return OI.jy_Gamepad2.getAxis(Joystick.AxisType.kX);
    }
    
    private double getGamepad2DHorizontal(){
        return OI.jy_Gamepad2.getAxis(Joystick.AxisType.kY);
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
