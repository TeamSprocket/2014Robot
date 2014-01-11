//Contributors: HC

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVisionException;
import team.sprocket.main.OI;

public class Sensors extends Subsystem {
    
    private final double conversionFactor = 0.0098;
    
    public Image getImage()throws AxisCameraException, NIVisionException{
        return OI.cm_axis.getImage();
    }
    
    //returns distance in inches
    public double getDistance(){
        double voltage = OI.u_ping.getVoltage();
        double distance = voltage / conversionFactor;
        
        return distance;
    }
    
    public double getAngle(){
        return OI.gy_gyro.getAngle() % 360;
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
