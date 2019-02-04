package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.base.util.Gains;
import frc.robot.base.util.PIDType;

import frc.robot.PIDSensor;
import frc.robot.RobotParameters;
import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.PIDController;

public class SubsystemDriver extends Subsystem5800 {
	private VictorSP motorFrontLeft = new VictorSP(DRIVE_MOTOR_FL_ID);
	private VictorSP motorRearLeft = new VictorSP(DRIVE_MOTOR_RL_ID);
	private VictorSP motorFrontRight = new VictorSP(DRIVE_MOTOR_FR_ID);
	private VictorSP motorRearRight = new VictorSP(DRIVE_MOTOR_RR_ID);

	private PIDSensor sensorLeft = new PIDSensor(CommandBase.sensors.driveEncoderL, CommandBase.sensors.gyro);
	private PIDSensor sensorRight = new PIDSensor(CommandBase.sensors.driveEncoderR, CommandBase.sensors.gyro);

	public SpeedControllerGroup gearLeft = new SpeedControllerGroup(motorFrontLeft, motorRearLeft){
		@Override
		public void pidWrite(double output){
			if (sensorLeft.mode == PIDType.kPosition){
				this.set(output);
			} else if (sensorLeft.mode == PIDType.kRate){
				this.set(this.get() + output);
			} else if (sensorRight.mode == PIDType.kAngle){
				this.set(output);
			} else {
				this.set(0);
			}
		}
	};
	public SpeedControllerGroup gearRight = new SpeedControllerGroup(motorFrontRight, motorRearRight){
		@Override
		public void pidWrite(double output){
			if (sensorRight.mode == PIDType.kPosition){
				this.set(output);
			} else if (sensorRight.mode == PIDType.kRate){
				this.set(this.get() + output);
			} else if (sensorRight.mode == PIDType.kAngle){
				this.set(-output);
			} else {
				this.set(0);
			}
		}
	};

	public PIDController controllerLeft = new PIDController(0.5, 0.0, 0.0, 
	sensorLeft, this.gearLeft);
	private PIDController controllerRight = new PIDController(0.5, 0.0, 0.0, 
	sensorRight, this.gearRight);

	public SubsystemDriver() {
		super();
		gearLeft.setInverted(false);
		gearRight.setInverted(true);

		sensorLeft.inPhase(1);
		sensorRight.inPhase(-1);

		controllerLeft.disable();
		controllerLeft.setOutputRange(-1.0, 1.0);
		controllerLeft.setName("controllerLeft");
		controllerLeft.setAbsoluteTolerance(0.05);
		
		controllerRight.disable();
		controllerRight.setOutputRange(-1.0, 1.0);
		controllerRight.setName("controllerRight");
		controllerRight.setAbsoluteTolerance(0.05);
	}

	public void setGains(Gains gains){
		controllerLeft.setPID(gains.kP, gains.kI, gains.kD, gains.kF);
		controllerRight.setPID(gains.kP, gains.kI, gains.kD, gains.kF);
	}

	public void setGains(Gains gainsL, Gains gainsR){
		controllerLeft.setPID(gainsL.kP, gainsL.kI, gainsL.kD, gainsL.kF);
		controllerRight.setPID(gainsR.kP, gainsR.kI, gainsR.kD, gainsR.kF);
	}
	
	public void setPIDMode(PIDType type){
		sensorLeft.mode = type;
		sensorRight.mode = type;	
	}

	public void setSetpoint(double setpoint){
		controllerLeft.setSetpoint(setpoint);
		controllerRight.setSetpoint(setpoint);
	}

	public void positionPID(double setpoint) {
		setPIDMode(PIDType.kPosition);
		gearRight.setInverted(true);
		sensorRight.inPhase(-1);
		setGains(RobotParameters.positionGains);
		setSetpoint(setpoint);
	}
	
	public void velocityPID(double left, double right){
		setPIDMode(PIDType.kRate);
		gearRight.setInverted(true);
		sensorRight.inPhase(-1);
		setGains(RobotParameters.leftRateGains, RobotParameters.rightRateGains);
		controllerLeft.setSetpoint(left);
		controllerRight.setSetpoint(right);
	}

	public void anglePID(double setpoint){
		setPIDMode(PIDType.kAngle);
		sensorRight.inPhase(1);
		setGains(RobotParameters.angleGains);
		setSetpoint(setpoint);
	}

	public void tankDrive(double _spLeft, double _spRight){
		gearLeft.set(_spLeft);
		gearRight.set(_spRight);
	}

	public void off(){
		controllerLeft.disable();
		controllerRight.disable();
	}

	public void on(){
		controllerLeft.enable();
		controllerRight.enable();
	}

	public boolean onTarget(){
		return controllerLeft.onTarget() && controllerRight.onTarget();
	}
}
