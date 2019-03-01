package frc.robot.base.commands.teleoperated;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandManualArm extends Command5800 {
    public CommandManualArm(){
        super(CommandBase.armLift);
    }

    protected void execute(){
    }
    
    protected boolean isDone(){
        return true;
    }
    
    protected void onCompletion(){
        CommandBase.armLift.status = !CommandBase.armLift.status;
    }
}