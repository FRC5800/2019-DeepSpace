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
        if (status){
            CommandBase.intake.hatchMotor(0.9);
        } else {
            CommandBase.intake.hatchMotor(-0.5);
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