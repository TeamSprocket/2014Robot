//Contributors: HC, TL, LW

package team.sprocket.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.sprocket.main.OI;
import team.sprocket.subsystems.Arm;
import team.sprocket.subsystems.DifferentialDriveTrain;
import team.sprocket.subsystems.MecanumDriveTrain;
import team.sprocket.subsystems.Sensors;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DifferentialDriveTrain differentialDriveTrain = new DifferentialDriveTrain();
    public static MecanumDriveTrain mecanumDriveTrain = new MecanumDriveTrain();
    public static Sensors sensors = new Sensors();
    public static Arm arm = new Arm();
   

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
