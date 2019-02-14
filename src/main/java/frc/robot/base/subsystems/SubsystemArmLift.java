package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotParameters;
import frc.robot.base.util.Gains;
import frc.robot.superclasses.Subsystem5800;

public class SubsystemArmLift extends Subsystem5800{
    public TalonSRX armMotor = new TalonSRX(ARM_MOTOR_ID);
    public TalonSRX armMotor2 = new TalonSRX(ARM_MOTOR_2_ID);
    public TalonSRX liftMotor = new TalonSRX(LIFT_MOTOR_ID);
    public TalonSRX liftMotor2 = new TalonSRX(LIFT_MOTOR_2_ID);

    
    public SubsystemArmLift(){
        super();
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        this.setGains(RobotParameters.armGains, armMotor);
        liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        this.setGains(RobotParameters.liftGains, liftMotor);
    }

    public void setGains(Gains _gains, TalonSRX _talon){
        _talon.config_kP(0, _gains.kP, 30);
        _talon.config_kI(0, _gains.kI, 30);
        _talon.config_kD(0, _gains.kD, 30);
        _talon.config_kF(0, _gains.kF, 30);
    }

    public void setArmMotor(double speed){
        this.armMotor.set(ControlMode.PercentOutput, speed);
        this.armMotor2.set(ControlMode.PercentOutput, -speed);
    }

    public void setLiftMotor(double speed){
        this.liftMotor.set(ControlMode.PercentOutput, speed);
        this.liftMotor2.set(ControlMode.PercentOutput, speed);
    }

    public void positionPIDArm(double _dis){
        armMotor.set(ControlMode.Position, _dis*4096);
        armMotor2.follow(armMotor);
    }

    public void positionPIDLift(double _dis){
        liftMotor.set(ControlMode.Position, _dis*4096);
        liftMotor2.follow(liftMotor);
    }
}