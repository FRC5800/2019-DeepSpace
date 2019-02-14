package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandCargoIntake extends Command5800 {
   
    boolean in = true;
    public CommandCargoIntake(){
        super(CommandBase.cargoIntake);
       
    }
    
    protected void execute(){
			cargoIntake.cargoIntake();
		
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
        cargoIntake.intakeStop();
    }
}