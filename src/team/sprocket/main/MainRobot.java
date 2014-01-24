//Contributors: HC, BH, LW, TL, HH, BK

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.sprocket.main;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import team.sprocket.commands.ButtonDrive;
import team.sprocket.commands.CommandBase;
import team.sprocket.commands.EBrake;
import team.sprocket.commands.TankDrive;
import team.sprocket.commands.TusharDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class MainRobot extends IterativeRobot {

    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        CommandList.autonomous.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        CommandList.autonomous.cancel();
        
        //CommandList.tusharDrive.start();
        //CommandList.tankDrive.start();
        CommandList.mecanumDrive.start();
        CommandList.accelerationMonitor.start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
