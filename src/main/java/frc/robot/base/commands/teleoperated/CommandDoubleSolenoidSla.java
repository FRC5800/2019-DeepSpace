package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandDoubleSolenoidSla extends Command5800 {
    public CommandDoubleSolenoidSla(){
        super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
        //hatchIntake.middleSolenoid();;
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
    }
}