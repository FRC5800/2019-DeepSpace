package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandCargoIntake extends Command5800 {
   
    public CommandCargoIntake(double speed){
        super(CommandBase.cargoIntake);
        cargoIntake.cargoIntakeSet(speed);
       
    }
    
    protected void execute(){
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
        cargoIntake.cargoIntakeSet(0);
    }
}