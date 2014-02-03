//Contributors: HC

package team.sprocket.main;

//holds static instances of all possible commands

import edu.wpi.first.wpilibj.command.Command;
import team.sprocket.commands.AccelerationMonitor;
import team.sprocket.commands.Autonomous;
import team.sprocket.commands.ButtonDrive;
import team.sprocket.commands.Cock;
import team.sprocket.commands.EBrake;
import team.sprocket.commands.Harvest;
import team.sprocket.commands.MecanumDrive;
import team.sprocket.commands.Plant;
import team.sprocket.commands.Shoot;
import team.sprocket.commands.ShootSequence;
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
    public static final Command cock = new Cock();
    public static final Command shoot = new Shoot();
    public static final Command harvest = new Harvest();
    public static final Command plant = new Plant();
    public static final Command shootSequence = new ShootSequence();
    public static final AccelerationMonitor accelerationMonitor = new AccelerationMonitor();

}
