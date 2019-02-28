package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandLift extends Command5800 {
    double dis;
    
    public CommandLift(double _dis){
        super(CommandBase.armLift);
        dis = _dis;
    }

    protected void execute(){
        CommandBase.armLift.positionPIDLift(dis);
    }

    protected boolean isDone(){
        return false;
    }

    protected void onCompletion(){
    }
}