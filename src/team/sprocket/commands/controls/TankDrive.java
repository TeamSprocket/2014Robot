//Contributors: HC, FH
package team.sprocket.commands.controls;

import edu.wpi.first.wpilibj.Relay;
import team.sprocket.commands.CommandBase;
import team.sprocket.main.OI;

public class TankDrive extends CommandBase {

    public TankDrive() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {

//        OI.solenoid1.set(true);
//        OI.solenoid2.set(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //press trigger to stop
        if (OI.jb_RightAttackTrigger.get() || OI.jb_LeftAttackTrigger.get()) {
            differentialDriveTrain.stop();
            return;
        }
        differentialDriveTrain.setLeftSide(OI.jy_LeftAttack.getY());

        differentialDriveTrain.setRightSide(OI.jy_RightAttack.getY());

        //press 3 to toggle pneumatics
//        if (OI.jb_LeftAttackTop.get() || OI.jb_RightAttackTop.get()) {
//            OI.solenoid1.set(!OI.solenoid1.get());
//            OI.solenoid2.set(!OI.solenoid2.get());
//
//        }
//        
//        if (!OI.ls_pneumaticControlSwitch.get()) {
//            OI.relay.set(Relay.Value.kOff);
//        } else {
//            OI.relay.set(Relay.Value.kOn);
//        }

    }

    private void shooterUpdate() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        //never stop 
    }

    // Called once after isFinished returns true
    protected void end() {
        differentialDriveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
