//Contributors: HC

package team.sprocket.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.sprocket.commands.shooter.ShootSequence;

/**
 *
 * @author Hall
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
        addSequential(new HotOrificeLocatingEntity());
        addSequential(new AutoMove());
        //addParallel(new MoveSafe());
        while(CommandBase.sensors.getTimer() < 5.15){
            //do nothing
        }
        addSequential(new AutomatedShootingSystem());
        addSequential(new ShootSequence());
    }
}
