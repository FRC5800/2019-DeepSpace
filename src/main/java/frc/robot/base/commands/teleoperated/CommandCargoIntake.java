package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;


public class CommandCargoIntake extends Command5800 {
    public CommandCargoIntake(double sp, boolean dr){
        super(CommandBase.cargoIntake);
        cargoIntake.speed = sp;
        cargoIntake.direction = dr;
    }
    
    protected void execute(){
        cargoIntake.cargoIntake(cargoIntake.direction, cargoIntake.speed);
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
        cargoIntake.cargoIntake(cargoIntake.direction, 0);
    }
}