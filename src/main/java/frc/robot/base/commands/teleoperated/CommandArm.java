package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandArm extends Command5800 {
    double dis;
    
    public CommandArm(double _dis){
        super(CommandBase.armLift);
        dis = _dis;
    }

    protected void execute(){
        CommandBase.armLift.positionPIDArm(dis);

    }

    protected boolean isDone(){
        return CommandBase.armLift.armOnTarget(0.1);
    }

    protected void onCompletion(){
    }
}