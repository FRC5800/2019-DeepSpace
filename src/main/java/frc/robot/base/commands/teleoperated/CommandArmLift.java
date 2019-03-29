package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.*;

public class CommandArmLift extends Command5800{

    double arm, lift, delay = 0;
    public CommandArmLift(double _arm, double _lift){
        super(CommandBase.armLift);
        this.arm = _arm;
        this.lift = _lift;
    }
    
    protected void onStart(){
        setTimeout(0.5);
    }

    protected void execute(){
        if(!CommandBase.armLift.status){
            CommandBase.armLift.armPID = this.arm;
            timer();
        }
    }
    
    protected void timer(){
        if (CommandBase.armLift.armOnTarget(0.1) && (isTimedOut())){
            delay++;
        }
    }

    protected boolean isDone(){
        return delay >= 25 || CommandBase.armLift.status;
    }
    
    protected void onCompletion(){
        CommandBase.armLift.liftPID = this.lift;
        delay = 0;
    }
}
