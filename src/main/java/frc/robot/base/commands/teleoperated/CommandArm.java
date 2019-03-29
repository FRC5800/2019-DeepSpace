package frc.robot.base.commands.teleoperated;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.*;

public class CommandArm extends Command5800 {
    double speed;
    public CommandArm(){
        super(CommandBase.armLift);
    }

    protected void execute(){
        this.speed = SubsystemJoystick.axis_j_Y.get();
        if(CommandBase.armLift.status){
            CommandBase.armLift.armMotor.set(ControlMode.PercentOutput, speed + 0.15);
            CommandBase.armLift.armMotor2.set(ControlMode.PercentOutput, speed + 0.15);
            CommandBase.armLift.armPID = 0;
        } else {
            CommandBase.armLift.positionPIDArm(armLift.armPID);
        }
        
        CommandBase.armLift.positionPIDLift(armLift.liftPID + 2000 - 2000 * SubsystemJoystick.axis_j_Slider.get());
    }

    protected boolean isDone(){
        return false;
    }

    protected void onCompletion(){
    }
}