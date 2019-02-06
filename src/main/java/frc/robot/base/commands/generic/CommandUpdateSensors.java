package frc.robot.base.commands.generic;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.util.Converter;
import frc.robot.superclasses.Command5800;
import frc.robot.RobotParameters;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;;

public class CommandUpdateSensors extends Command5800 {

	public CommandUpdateSensors() {
		super(CommandBase.sensors);
	}

	@Override
	protected void onStart(){
		SmartDashboard.putNumber("kP", RobotParameters.rateGains.kP);
		SmartDashboard.putNumber("kI", RobotParameters.rateGains.kI);
		SmartDashboard.putNumber("kD", RobotParameters.rateGains.kD);
		SmartDashboard.putBoolean("VelocityPID", CommandBase.sensors.velocityPID);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Gyro", CommandBase.sensors.getChassiAngle());
		SmartDashboard.putNumber("Distance Encoder L", CommandBase.sensors.driveEncoderL.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Distance Encoder R", CommandBase.sensors.driveEncoderR.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Error", CommandBase.driver.controllerLeft.getError());
		SmartDashboard.putNumber("Speed", CommandBase.sensors.driveEncoderR.getRate()*Math.PI*15/360);
		SmartDashboard.putBoolean("VelocityPID", CommandBase.sensors.velocityPID);

		RobotParameters.rateGains.kP = SmartDashboard.getNumber("kP", 0);
		RobotParameters.rateGains.kI = SmartDashboard.getNumber("kI", 0);
		RobotParameters.rateGains.kD = SmartDashboard.getNumber("kD", 0);
		CommandBase.sensors.velocityPID = SmartDashboard.getBoolean("VelocityPID", false);

		sensors.complete = SmartDashboard.getBoolean("Complete", false);
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	@Override
	protected void onCompletion() {
	}
}
