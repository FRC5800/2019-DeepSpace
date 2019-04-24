package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandHatchMotor extends Command5800 {
    private boolean status;
    
    public CommandHatchMotor(boolean _st){
        super(CommandBase.intake);
        this.status = _st;
    }
    
    protected void execute(){
        CommandBase.intake.cargoIntakeSet(0);
        if (!status){
            CommandBase.intake.hatchMotor(0.8);
        } else {
            CommandBase.intake.hatchMotor(-0.8);
        }
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
        CommandBase.intake.hatchMotor(0.15);
        CommandBase.intake.status = this.status;
    }
}