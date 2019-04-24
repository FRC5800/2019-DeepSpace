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
        CommandBase.armLift.liftMotor.set(ControlMode.Position, CommandBase.armLift.liftPID + 1500 * (1 - SubsystemJoystick.axis_j_Slider.get()));

        this.speed = SubsystemJoystick.axis_j_Y.get();
        CommandBase.armLift.armSet(this.speed + 0.12, 0.05);
    }

    protected boolean isDone(){
        return false;
    }

    protected void onCompletion(){
    }
}