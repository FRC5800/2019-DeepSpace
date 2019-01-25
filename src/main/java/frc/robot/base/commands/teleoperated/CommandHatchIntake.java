package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

/**
 * Add your docs here.
 */
public class CommandHatchIntake extends Command5800 {
    public CommandHatchIntake(){
        super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
    }
    
    protected boolean isDone(){
        return true;
    }
    
    protected void onCompletion(){
        hatchIntake.state = !hatchIntake.state;
        hatchIntake.hatchIntake(hatchIntake.state);
    }
}