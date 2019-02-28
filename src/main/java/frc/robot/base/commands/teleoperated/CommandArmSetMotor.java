package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandArmSetMotor extends Command5800 {
    double speed;
    
    public CommandArmSetMotor(double _sp){
        super(CommandBase.armLift);
        speed = _sp;
    }
    
    protected void execute(){
        CommandBase.armLift.setArmMotor(speed);

    }

    protected boolean isDone(){
        return CommandBase.sensors.sla;
    }

    protected void onCompletion(){
        CommandBase.sensors.sla = false;
        CommandBase.armLift.setArmMotor(0);
    }
}