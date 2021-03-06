//Contributors: HC

package team.sprocket.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import team.sprocket.main.OI;

public class Sensors extends Subsystem {
    
    private final double conversionFactor = 0.0098;
    private final double microsecond = 0.000001;
    private NetworkTable server = NetworkTable.getTable("SmartDashboard");
    private boolean hot = false;
    private Timer tim = new Timer();
    
    public void setHot(boolean state){
        hot = state;
    }
    
    public void stopTimer(){
        tim.stop();
    }
    
    public void startTimer(){
        tim.start();
    }
    
    public void resetTimer(){
        tim.reset();
    }
    
    public double getTimer(){
        return tim.get();
    }
    
    public boolean getHot(){
        return hot;
    }
    
    public double getBlobCount(){
        try{
            return server.getNumber("BLOB_COUNT");
        }
        catch(Exception e){
            System.out.println("Error");
        }
        return -1;
    }
    
    public double getArmPot(){
        return OI.p_Arm.getVoltage();
    }
    
    public boolean harvesterRaiseLimit(){
        return OI.ls_harvesterRaiseLimit.get();
    }
    
    public boolean harvesterLowerLimit(){
        return OI.ls_harvesterLowerLimit.get();
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
    
    //arr[0] returns left proximity value
    //arr[1] returns right proximity value
    //arr[2] returns average proximity value
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
    public double getRightPing(){
        double voltage = OI.u_rightPing.getVoltage();
        double distance = voltage / conversionFactor;
        
        return distance;
    }
    
    public double getLeftPing(){
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
