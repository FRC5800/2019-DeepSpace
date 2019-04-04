package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandLift extends Command5800 {
    double dis;
    
    public CommandLift(double _dis){
        super(null);
        dis = _dis;
    }

    protected void execute(){
        CommandBase.armLift.liftPID = dis;
    }

    protected boolean isDone(){
        return true;
    }

    protected void onCompletion(){
    }
}