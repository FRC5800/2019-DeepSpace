package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandLiftArm extends Command5800{

    double arm, lift, delay = 0;
    public CommandLiftArm(double _arm, double _lift){
        super(CommandBase.armLift);
        this.arm = _arm;
        this.lift = _lift;
    }
    
    protected void onStart(){
        setTimeout(0.5);
    }

    protected void execute(){
        CommandBase.armLift.positionPIDLift(this.lift);
        timer();
    }
    
    protected void timer(){
        if (CommandBase.armLift.liftOnTarget(100) && (isTimedOut())){
            delay++;
        }
    }
    
    protected boolean isDone(){
        return delay >= 25;
    }
    
    protected void onCompletion(){
        if (!CommandBase.armLift.status){
            CommandBase.armLift.positionPIDArm(this.arm);
        }
        delay = 0;
    }
}
