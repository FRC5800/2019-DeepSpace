package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

/**
 * Add your docs here.
 */
public class CommandLift extends Command5800 {
    double speed;
    
    public CommandLift(double _sp){
        super(CommandBase.lift);
        speed = _sp;
    }
    
    protected void execute(){
        CommandBase.lift.setMotor(speed);
    }

    protected boolean isDone(){
        return false;
    }

    protected void onCompletion(){
        CommandBase.lift.setMotor(0.15);
    }
}