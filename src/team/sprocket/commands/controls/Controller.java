//Contributors: HC, TN, BK, FH
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
        if (!sensors.advanceLatchLimit() && !getJoystickBottom()) {
            CommandList.cock.start();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //arm.advanceLatch();
        jy = getGamepadYAxis();
        modifiedUpSpeed = 1;
        modifiedDownSpeed = 1;

        SmartDashboard.putString("Pot Value: ", new Double(sensors.getArmPot()).toString());
        SmartDashboard.putBoolean("Cock Limit: ", sensors.cockLimit());
        SmartDashboard.putBoolean("Latch A Limit: ", sensors.advanceLatchLimit());
        SmartDashboard.putBoolean("Latch W Limit: ", sensors.withdrawLatchLimit());
        SmartDashboard.putBoolean("Harvester Raise Limit: ", sensors.harvesterRaiseLimit());
        SmartDashboard.putBoolean("Harvester Lower Limit: ", sensors.harvesterLowerLimit());
        SmartDashboard.putBoolean("Arm Bottom Limit: ", sensors.armLowerLimit());
        SmartDashboard.putBoolean("Arm Top Limit: ", sensors.armRaiseLimit());

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
//        if(getGamepadLT() || getGamepadRT()){
//            //harvester listener
//            if(getGamepadLT()){
//                arm.rollIn(harvestspeed);               //Harvest
//            }
//            //plant listener
//            if(getGamepadRT()){
//                arm.rollOut(harvestspeed);              //Plant
//            }
//        }
//        else arm.rollStop();
        //harvester controls
        if (Math.abs(getRawAxis()) == 1) {
            if (getRawAxis() == 1) {
                if (!sensors.harvesterRaiseLimit()) {
                    arm.harvesterUp();
                }
            }
            if (getRawAxis() == -1) {
                if (!CommandList.lowerHarvester.isRunning()) {
                    CommandList.lowerHarvester.start();
                }
            }
        } else if (!CommandList.shoot.isRunning() && !CommandList.cock.isRunning() && !CommandList.shootSequence.isRunning()) {
            arm.harvesterStop();
        }

        /*if(getJoystickTop() && !CommandList.automatedShootingSystem.isRunning()){
         CommandList.automatedShootingSystem.start();
         }*/
        //Shoot Listener
        //b to shoot
        // needs testing
        if (getGamepadB() && !CommandList.shootSequence.isRunning()) {
            CommandList.shootSequence.start();
        }

        if (getGamepadB() && !CommandList.shootSequence.isRunning()) {
            CommandList.shoot.start();
        }

        if (!CommandList.moveArmToLowerPosition.isRunning()) {
            CommandList.moveArmToLowerPosition.start();
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
        //use left throttle and left joystick to move arm
        if (getLeftThrottle() && Math.abs(jy) > deadband) {
            //arm up listener

            if (sensors.getArmPot() < 0.5) {
                modifiedDownSpeed = 0.33;
            }

            if (sensors.getArmPot() > 4.7) {
                modifiedUpSpeed = 0.68;
            }

            if (jy > 0) {
                if (!sensors.armRaiseLimit()) {
                    arm.armUp(modifiedUpSpeed);
                } else {
                    arm.armStop();
                }
            }
            //arm down listener
            if (jy < 0) {
                if (!sensors.armLowerLimit()) {
                    arm.armDown(modifiedDownSpeed);
                } else {
                    arm.armStop();
                }
            }

        } else {
            arm.armStop();
        }
        
        //y to lower, a to raise
        if (getGamepadY() || getGamepadA()) {
            if (getGamepadY() && !sensors.harvesterLowerLimit()) {
                arm.harvesterDown();
            } else if (getGamepadA() && !sensors.harvesterRaiseLimit()) {
                arm.harvesterUp();
            } else {
                arm.harvesterStop();
            }
        } else {
            arm.harvesterStop();
        }
    }

    private boolean getGamepadA() {
        return OI.jb_GamepadA.get();
    }

    private double getRawAxis() {
        return -OI.jy_Gamepad.getRawAxis(6);
    }

    private boolean getGamepadB() {
        return OI.jb_GamepadB.get();
    }

    private boolean getLeftThrottle() {
        return OI.jb_LeftGamepadThrottle.get();
    }

    private boolean getGamepadY() {
        return OI.jb_GamepadY.get();
    }

    private boolean getGamepadLT() {
        return OI.jb_LeftGamepadThrottle.get();
    }

    private boolean getGamepadRT() {
        return OI.jb_RightGamepadThrottle.get();
    }

    private double getGamepadYAxis() {

        return -OI.jy_Gamepad.getAxis(Joystick.AxisType.kY);

    }

    private double getJoystickY() {
        return OI.jy_LeftAttack.getAxis(Joystick.AxisType.kY);
    }

    private boolean getJoystickTrigger() {
        return OI.jb_LeftAttackTrigger.get();
    }

    private boolean getJoystickTop() {
        return OI.jb_LeftAttackTop.get();
    }

    private boolean getJoystickBottom() {
        return OI.jb_LeftAttackBottom.get();
    }

    private boolean getJoystick8() {
        return OI.jb_LeftAttack9.get();
    }

    private boolean getJoystick9() {
        return OI.jb_LeftAttack9.get();
    }

    private boolean getJoystick4() {
        return OI.jb_LeftAttack4.get();
    }

    private boolean getJoystick5() {
        return OI.jb_LeftAttack5.get();
    }

    private boolean getJoystick6() {
        return OI.jb_LeftAttack6.get();
    }

    private boolean getJoystick7() {
        return OI.jb_LeftAttack7.get();
    }

    private boolean getJoystick10() {
        return OI.jb_LeftAttack10.get();
    }

    private boolean getJoystick11() {
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
