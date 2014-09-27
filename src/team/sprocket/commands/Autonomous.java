package team.sprocket.commands;

import com.team254.CheesyVisionRobot;
import com.team254.lib.CheesyVisionServer;
import team.sprocket.main.CommandList;

public class Autonomous extends CommandBase {

    private CheesyVisionRobot cheesyCheetos;
    private CheesyVisionServer cheetos;
    private boolean shooting = false;

    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        cheesyCheetos = new CheesyVisionRobot();
        cheetos = CheesyVisionServer.getInstance();
        cheesyCheetos.autonomousInit();
        cheetos.run();  //not sure which one to call
        cheetos.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        CommandList.moveForward.start();
        while (CommandList.moveForward.isRunning()) {
        }
        while (!sensors.harvesterLowerLimit()) {
            arm.harvesterDown();
        }
//        while (!sensors.harvesterRaiseLimit()) {
//            arm.harvesterUp();
//        }
        arm.harvesterStop();
        //if the person has been holding his hands over the yellow squares for
        //over 10*50 = 500 millis, then the shootsequnce starts
        if (cheetos.getTotalCount() >= 10 && !shooting) {
            CommandList.shootSequence.start();
            shooting = true;
        }

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
