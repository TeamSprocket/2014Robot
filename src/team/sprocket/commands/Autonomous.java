//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.Timer;
import team.sprocket.main.CommandList;

/*

I hereby invoke the spirit of innovation,
the essence of ingenuity, and the scent of


*/

public class Autonomous extends CommandBase {
    
    //private Image image;
    private final double safeArmPosition = 1;
    
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
        
        CommandList.hotOrificeLocatingEntity.start();             //get stuck here until hot is located
        arm.moveArmTo(safeArmPosition);
        
        while(sensors.getLeftPing() > 120){
            differentialDriveTrain.allForward(0.75);
        }
        differentialDriveTrain.stop();
        
        //arm.moveArmTo(4.38);
        CommandList.automatedShootingSystem.start();
        CommandList.shootSequence.start();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
