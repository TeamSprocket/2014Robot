//Contributors: HC, BH, TL

package team.sprocket.commands;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.sprocket.main.OI;
import java.util.*;

public class MecanumDrive extends CommandBase {
    
    private final double deadBand = 0.1;
    
    private double bearing;
    private double magnitude;
    private double jx, jy;      //joystick axis values
    
    
    public MecanumDrive() {
        requires(mecanumDriveTrain);
    }
    
    protected void initialize() {
        bearing = sensors.getAngle();
    }

    protected void execute() {
        jx = getJoystickX();
        jy = getJoystickY();
        if(Math.abs(jx) > deadBand || Math.abs(jy) > deadBand){     //if outside deadband
            magnitude = Math.sqrt(MathUtils.pow(jx,2) + MathUtils.pow(jy,2));
            findBearing();
            quadrantCompensation();
            SmartDashboard.putNumber("Bearing: ", bearing);
            SmartDashboard.putNumber("Magnitude: ", magnitude);
            mecanumDriveTrain.translate(magnitude, bearing);
            return;
        }
        if(Math.abs(getJoystickZ()) > deadBand){
            mecanumDriveTrain.turn(getJoystickZ());
        }
        else mecanumDriveTrain.stop();
    }
    
    private void findBearing(){
        if(jy == 0){
            System.out.println("zero");
            if(jx > 0){
                bearing = 90;
            }
            if(jx < 0){
                bearing = -90;
            }
        }
        else{
            System.out.println("NOT zero");
            bearing = Math.toDegrees(MathUtils.atan(jx / jy));
        }
    }
    
    private void quadrantCompensation(){
        if(jy < 0){
            bearing += 180;
            bearing %= 360;
        }
    }
    
    private double getJoystickX(){
        return OI.jy_Gamepad.getAxis(Joystick.AxisType.kX);
    }
    private double getJoystickY(){
        return OI.jy_Gamepad.getAxis(Joystick.AxisType.kY);
    }
    
    private double getJoystickZ(){
        return OI.jy_Gamepad.getAxis(Joystick.AxisType.kZ);
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
