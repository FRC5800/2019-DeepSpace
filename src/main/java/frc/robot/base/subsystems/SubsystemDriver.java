package frc.robot.base.subsystems;

import static frc.robot.RobotMap.DRIVE_MOTOR_FL_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_FR_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_RL_ID;
import static frc.robot.RobotMap.DRIVE_MOTOR_RR_ID;

import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class SubsystemDriver extends Subsystem5800 {
	private VictorSP motorFrontLeft = new VictorSP(DRIVE_MOTOR_FL_ID);
	private VictorSP motorRearLeft = new VictorSP(DRIVE_MOTOR_RL_ID);
	private VictorSP motorFrontRight = new VictorSP(DRIVE_MOTOR_FR_ID);
	private VictorSP motorRearRight = new VictorSP(DRIVE_MOTOR_RR_ID);

	private SpeedControllerGroup motorLeft = new SpeedControllerGroup(motorFrontLeft, motorRearLeft);
	private SpeedControllerGroup motorRight = new SpeedControllerGroup(motorFrontRight, motorRearRight);
	private DifferentialDrive driveTrain = new DifferentialDrive(motorLeft, motorRight);

	public SubsystemDriver() {
		super();
	}

	@Override
	public void onInit() {
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	public void arcadeDrive(double speed, double heading) {
		driveTrain.arcadeDrive(speed, heading);
	}

	public void driveTrainLeft(double speed) {
		this.motorLeft.set(speed);
	}

	public void driveTrainRight(double speed) {
		this.motorRight.set(speed);
	}
}
