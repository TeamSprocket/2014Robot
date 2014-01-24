//Contributors: HC

package team.sprocket.main;

//holds static instances of all possible commands

import edu.wpi.first.wpilibj.command.Command;
import team.sprocket.commands.AccelerationMonitor;
import team.sprocket.commands.Autonomous;
import team.sprocket.commands.ButtonDrive;
import team.sprocket.commands.EBrake;
import team.sprocket.commands.MecanumDrive;
import team.sprocket.commands.TankDrive;
import team.sprocket.commands.TusharDrive;

//formerly known as Init class in 2013Robot code
public class CommandList {
    
    public static final Command buttonDrive = new ButtonDrive();
    public static final Command autonomous = new Autonomous();
    public static final Command tankDrive = new TankDrive();
    public static final Command tusharDrive = new TusharDrive();
    public static final Command eBrake = new EBrake();
    public static final Command mecanumDrive = new MecanumDrive();
    public static final AccelerationMonitor accelerationMonitor = new AccelerationMonitor();

}
