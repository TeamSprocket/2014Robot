//Contributors: HC

package team.sprocket.main;

//holds static instances of all possible commands

import edu.wpi.first.wpilibj.command.Command;
import team.sprocket.commands.AccelerationMonitor;
import team.sprocket.commands.AutomatedShootingSystem;
import team.sprocket.commands.Autonomous;
import team.sprocket.commands.EBrake;
import team.sprocket.commands.HotOrificeLocatingEntity;
import team.sprocket.commands.MoveForward;
import team.sprocket.commands.controls.ButtonDrive;
import team.sprocket.commands.controls.MecanumDrive;
import team.sprocket.commands.controls.TankDrive;
import team.sprocket.commands.controls.TusharDrive;
import team.sprocket.commands.controls.Controller1;
import team.sprocket.commands.controls.Controller2;
import team.sprocket.commands.shooter.Cock;
import team.sprocket.commands.shooter.Harvest;
import team.sprocket.commands.shooter.LowerHarvester;
import team.sprocket.commands.shooter.MoveArmToLowerPosition;
import team.sprocket.commands.shooter.MoveArmToUpperPosition;
import team.sprocket.commands.shooter.Plant;
import team.sprocket.commands.shooter.Shoot;
import team.sprocket.commands.shooter.ShootSequence;
import team.sprocket.commands.shooter.SoftRelease;

//formerly known as Init class in 2013Robot code
public class CommandList {
    
    public static final Command buttonDrive = new ButtonDrive();
    public static final Command moveForward = new MoveForward();
    public static final Command autonomous = new Autonomous();
    public static final Command tankDrive = new TankDrive();
    public static final Command tusharDrive = new TusharDrive();
    public static final Command eBrake = new EBrake();
    public static final Command mecanumDrive = new MecanumDrive();
    public static final Command moveArmToLowerPosition = new MoveArmToLowerPosition();
    public static final Command moveArmToUpperPosition = new MoveArmToUpperPosition();
    public static final Command cock = new Cock();
    public static final Command shoot = new Shoot();
    public static final Command softRelease = new SoftRelease();
    public static final Command harvest = new Harvest();
    public static final Command controller1 = new Controller1();
    public static final Command controller2 = new Controller2();
    public static final Command plant = new Plant();
    public static final Command shootSequence = new ShootSequence();
    public static final Command automatedShootingSystem = new AutomatedShootingSystem();
    public static final Command hotOrificeLocatingEntity = new HotOrificeLocatingEntity();
    public static final Command lowerHarvester = new LowerHarvester();
    public static final AccelerationMonitor accelerationMonitor = new AccelerationMonitor();

}
