package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandDoubleSolenoidActive extends Command5800 {
    public CommandDoubleSolenoidActive(){
        super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
        hatchIntake.activeDoubleSolenoid();
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
    }
}