//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.main.CommandList;

public class Autonomous extends CommandBase {
    
    //private Image image;
    
    public Autonomous() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        /*try{
            image = sensors.getImage();
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while(sensors.getPingArray()[3] > 100){
            differentialDriveTrain.allForward(0.5);
        }
        differentialDriveTrain.stop();
        
        CommandList.autoAimSystem.start();
        Timer.delay(1);
        CommandList.shootSequence.start();
        
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
