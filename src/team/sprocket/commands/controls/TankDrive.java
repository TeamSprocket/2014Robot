//Contributors: HC

package team.sprocket.commands.controls;

import team.sprocket.commands.CommandBase;
import team.sprocket.main.OI;

public class TankDrive extends CommandBase {
    
    public TankDrive() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*if(OI.jb_LeftAttackTrigger.get()){
            differentialDriveTrain.setLeftSide(OI.jy_LeftAttack.getY());
        }
        if(OI.jb_RightAttackTrigger.get()){
            differentialDriveTrain.setRightSide(OI.jy_RightAttack.getY());
        }
        else differentialDriveTrain.stop();*/
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
