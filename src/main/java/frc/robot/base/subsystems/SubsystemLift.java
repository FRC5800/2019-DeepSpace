package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotParameters;
import frc.robot.base.util.Gains;
import frc.robot.superclasses.Subsystem5800;

public class SubsystemLift extends Subsystem5800{
    public TalonSRX liftMotor = new TalonSRX(LIFT_MOTOR_ID);
    public TalonSRX liftMotor2 = new TalonSRX(LIFT_MOTOR_2_ID);
    public boolean status = true;
    public double liftPID = 0;
    
    public SubsystemLift(){
        super();
        liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        this.setGains(RobotParameters.liftGains, liftMotor);

        //liftMotor.configClosedloopRamp(0.1);

        liftMotor.setSensorPhase(true);

        liftMotor.configPeakOutputForward(1);
        liftMotor.configPeakOutputReverse(-0.5);
    }

    public void setGains(Gains _gains, TalonSRX _talon){
        _talon.config_kP(0, _gains.kP, 30);
        _talon.config_kI(0, _gains.kI, 30);
        _talon.config_kD(0, _gains.kD, 30);
        _talon.config_kF(0, _gains.kF, 30);
    }

    public void setLiftMotor(double speed){
        this.liftMotor.set(ControlMode.PercentOutput, speed);
        this.liftMotor2.set(ControlMode.PercentOutput, speed);
    }

    public void positionPIDLift(double _dis){
        liftMotor.set(ControlMode.Position, _dis);
        liftMotor2.follow(liftMotor);
    }

    public boolean liftOnTarget(double _t){
        if (liftMotor.getControlMode() == ControlMode.Position){
            return Math.abs(liftMotor.getClosedLoopError()) < _t;
        } else {
            return false;
        }
    }
}