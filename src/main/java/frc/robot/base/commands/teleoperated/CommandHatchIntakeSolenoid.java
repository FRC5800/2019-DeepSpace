package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

/**
 * Add your docs here.
 */

public class CommandHatchIntakeSolenoid extends Command5800 {

    public CommandHatchIntakeSolenoid(){
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