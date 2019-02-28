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
        CommandBase.armLift.positionPIDArm(200);

    }

    protected boolean isDone(){
        return CommandBase.sensors.sla;
    }

    protected void onCompletion(){
        CommandBase.sensors.sla = false;
        CommandBase.armLift.setLiftMotor(0);
    }
}