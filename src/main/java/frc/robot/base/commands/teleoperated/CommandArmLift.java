package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandArmLift extends Command5800{

    double arm, lift, delay = 0;
    public CommandArmLift(double _arm, double _lift){
        super(CommandBase.armLift);
        this.arm = _arm;
        this.lift = _lift;
    }
    
    protected void execute(){
        CommandBase.armLift.positionPIDArm(this.arm);
        delay++;
    }
    
    protected boolean isDone(){
        return CommandBase.armLift.armOnTarget(0.05) && (delay >= 10);
    }
    
    protected void onCompletion(){
        CommandBase.armLift.positionPIDLift(this.lift);
        delay = 0;
    }
}
