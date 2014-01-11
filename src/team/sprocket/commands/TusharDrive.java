//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Joystick;
import team.sprocket.main.OI;

public class TusharDrive extends CommandBase {
    
    private double leftPower;
    private double rightPower;
    
    public TusharDrive() {
        requires(differentialDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(OI.jb_RightThrottle.get()){
            updateValues();
            differentialDriveTrain.setLeftSide(leftPower);
            differentialDriveTrain.setRightSide(rightPower);
            return;
        }
        if(OI.jb_LeftThrottle.get()){
            updateValues();
            differentialDriveTrain.setLeftSide(-1*leftPower);
            differentialDriveTrain.setRightSide(-1*rightPower);
        }
        else differentialDriveTrain.stop();
    }
    
    private void updateValues(){
        if(OI.jy_Gamepad.getAxis(Joystick.AxisType.kX) > 0){
            leftPower = OI.jy_Gamepad.getAxis(Joystick.AxisType.kX);
            rightPower = 1 - leftPower;
            return;
        }
        if(OI.jy_Gamepad.getAxis(Joystick.AxisType.kX) < 0){
            rightPower = -1* OI.jy_Gamepad.getAxis(Joystick.AxisType.kX);
            leftPower = 1 - rightPower;
            return;
        }
        if(OI.jy_Gamepad.getAxis(Joystick.AxisType.kX) == 0){
            rightPower = 1;
            leftPower = 1;
        }
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
