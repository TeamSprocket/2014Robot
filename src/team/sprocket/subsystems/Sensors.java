//Contributors: HC

package team.sprocket.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVisionException;
import team.sprocket.main.OI;

public class Sensors extends Subsystem {
    
    private final double conversionFactor = 0.0098;
    private final double microsecond = 0.000001;
    
    public Image getImage()throws AxisCameraException, NIVisionException{
        return OI.cm_axis.getImage();
    }
    
    public double getArmPot(){
        return OI.p_Arm.getVoltage();
    }
    
    public double getArmAngle(){
        double voltage = getArmPot();
        double angle = 79.63644937*voltage;                             //formula to be implemented
        return angle;
    }
    
    public boolean harvesterLimit(){
        return OI.ls_harvesterRaiseLimit.get();
    }
    
    public boolean cockLimit(){
        return OI.ls_rackLimit.get();
    }
    
    public boolean advanceLatchLimit(){
        return OI.ls_advanceLatchLimit.get();
    }
    
    public boolean withdrawLatchLimit(){
        return OI.ls_withdrawLatchLimit.get();
    }
    
    public boolean armLowerLimit(){
        return OI.ls_armLowerLimit.get();
    }
    
    public boolean armRaiseLimit(){
        return OI.ls_armRaiseLimit.get();
    }
    
    public double[] getPingArray(){
        double[] arr = new double[3];
        
        OI.rx_LeftPing.set(true);
        Timer.delay(100*microsecond);
        arr[0] = getLeftPing();
        OI.rx_LeftPing.set(false);
        
        Timer.delay(500*microsecond);
        
        OI.rx_RightPing.set(true);
        Timer.delay(100*microsecond);
        arr[1] = getRightPing();
        OI.rx_RightPing.set(false);
        
        Timer.delay(100*microsecond);
        
        arr[2] = (arr[0] + arr[1])/2;
        
        return arr;
    }
    
    //returns distance in inches
    private double getRightPing(){
        double voltage = OI.u_rightPing.getVoltage();
        double distance = voltage / conversionFactor;
        
        return distance;
    }
    
    private double getLeftPing(){
        double voltage = OI.u_leftPing.getVoltage();
        double distance = voltage / conversionFactor;
        
        return distance;
    }
    
    public double getAccelerationX(){
        return OI.ac_main.getAcceleration(ADXL345_I2C.Axes.kX);
    }
    
    public double getAccelerationY(){
        return OI.ac_main.getAcceleration(ADXL345_I2C.Axes.kY);
    }
    
    public double getAccelerationZ(){
        return OI.ac_main.getAcceleration(ADXL345_I2C.Axes.kZ);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
