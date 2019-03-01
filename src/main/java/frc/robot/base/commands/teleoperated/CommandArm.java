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
        this.speed = - SubsystemJoystick.axis_j_Y.get();
        if(CommandBase.armLift.status){
            CommandBase.armLift.armMotor.set(ControlMode.PercentOutput, speed);
            CommandBase.armLift.armMotor2.set(ControlMode.PercentOutput, speed);
        }
    }

    protected boolean isDone(){
        return false;
    }

    protected void onCompletion(){
    }
}