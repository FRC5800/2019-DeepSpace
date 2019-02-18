package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandCargoIntake extends Command5800 {
    double speed;

    public CommandCargoIntake(double speed){
        super(CommandBase.cargoIntake);
        this.speed = speed;
    }
    
    protected void execute(){
        cargoIntake.cargoIntakeSet(speed);
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
        cargoIntake.cargoIntakeSet(0);
    }
}