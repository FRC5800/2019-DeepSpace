package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.*;

public class CommandArmLift extends Command5800{

    double arm, lift;
    public CommandArmLift(double _arm, double _lift){
        super(CommandBase.armLift);
        this.arm = _arm;
        this.lift = _lift;
    }
      
    protected void execute(){
        armLift.positionPIDArm(this.arm);
        if (armLift.armMotor.getClosedLoopError() < 50){
            armLift.positionPIDLift(this.lift);
        }
    }
    
    protected boolean isDone(){
        return false;
    }
    
    protected void onCompletion(){
    }
}
