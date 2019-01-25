package frc.robot.base.subsystems;

import static frc.robot.RobotMap.DRIVE_ENCODER_L1_ID;
import static frc.robot.RobotMap.DRIVE_ENCODER_L2_ID;
import static frc.robot.RobotMap.DRIVE_ENCODER_R1_ID;
import static frc.robot.RobotMap.DRIVE_ENCODER_R2_ID;
import static frc.robot.RobotMap.ELEVATOR_LIMIT_BOTTOM_ID;
import static frc.robot.RobotMap.ELEVATOR_LIMIT_TOP_ID;

import frc.robot.base.util.Converter;
import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class SubsystemSensors extends Subsystem5800 {
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private Encoder driveEncoderR = new Encoder(DRIVE_ENCODER_R1_ID, DRIVE_ENCODER_R2_ID);
	private Encoder driveEncoderL = new Encoder(DRIVE_ENCODER_L1_ID, DRIVE_ENCODER_L2_ID);
	private DigitalInput elevatorLimitTop = new DigitalInput(ELEVATOR_LIMIT_TOP_ID);
	private DigitalInput elevatorLimitBottom = new DigitalInput(ELEVATOR_LIMIT_BOTTOM_ID);

	public void init() {
		this.gyro.reset();
		this.gyro.calibrate();
		this.driveEncoderL.reset();
		this.driveEncoderR.reset();
	}

	public void reset() {
		this.driveEncoderL.reset();
		this.driveEncoderR.reset();
	}

	public int getChassiPulses(char selector) {
		int pulses = 0;
		if (selector == 'L') {
			pulses = this.driveEncoderL.getRaw();
		} else if (selector == 'R') {
			pulses = this.driveEncoderR.getRaw();
		}
		return pulses;
	}

	public double getChassiSpeed(char selector) {
		double speed = 0;
		if (selector == 'L') {
			speed = Converter.convertMetric(Converter.convertEncoder(this.driveEncoderL.getRate(), 'P'), 'C');
		} else if (selector == 'R') {
			speed = Converter.convertMetric(Converter.convertEncoder(this.driveEncoderR.getRate(), 'P'), 'C');
		}
		return speed;
	}

	public double getChassiAngle() {
		return gyro.getAngle();
	}

	public boolean getElevatorLimit(char selector) {
		boolean status = false;
		if (selector == 'T') {
			status = this.elevatorLimitTop.get();
		} else if (selector == 'B') {
			status = this.elevatorLimitBottom.get();
		}
		return !status;
	}
}