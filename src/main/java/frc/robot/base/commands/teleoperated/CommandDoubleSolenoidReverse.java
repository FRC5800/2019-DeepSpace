package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandDoubleSolenoidReverse extends Command5800 {
    public CommandDoubleSolenoidReverse(){
        super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
        hatchIntake.activeReverseDoubleSolenoid();
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
    }
}