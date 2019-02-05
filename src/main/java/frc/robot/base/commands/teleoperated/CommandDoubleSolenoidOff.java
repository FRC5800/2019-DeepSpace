package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandDoubleSolenoidOff extends Command5800 {
    public CommandDoubleSolenoidOff(){
        super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
        hatchIntake.disactiveDoubleSolenoid();;
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
    }
}