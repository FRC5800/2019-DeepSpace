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
		SmartDashboard.putNumber("lP", RobotParameters.leftRateGains.kP);
		SmartDashboard.putNumber("lI", RobotParameters.leftRateGains.kI);
		SmartDashboard.putNumber("lD", RobotParameters.leftRateGains.kD);
		SmartDashboard.putNumber("rP", RobotParameters.rightRateGains.kP);
		SmartDashboard.putNumber("rI", RobotParameters.rightRateGains.kI);
		SmartDashboard.putNumber("rD", RobotParameters.rightRateGains.kD);
		SmartDashboard.putBoolean("VelocityPID", CommandBase.sensors.velocityPID);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Gyro", CommandBase.sensors.getChassiAngle());
		SmartDashboard.putNumber("Distance Encoder L", CommandBase.sensors.driveEncoderL.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Distance Encoder R", CommandBase.sensors.driveEncoderR.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Error", CommandBase.driver.controllerLeft.getError());
		SmartDashboard.putNumber("Speed Right", CommandBase.sensors.driveEncoderR.getRate()*Math.PI*15/36000);
		SmartDashboard.putNumber("Speed Left", CommandBase.sensors.driveEncoderL.getRate()*Math.PI*15/36000);
		SmartDashboard.putBoolean("VelocityPID", CommandBase.sensors.velocityPID);

		RobotParameters.leftRateGains.kP = SmartDashboard.getNumber("lP", 0);
		RobotParameters.rightRateGains.kP = SmartDashboard.getNumber("rP", 0);
		RobotParameters.leftRateGains.kI = SmartDashboard.getNumber("lI", 0);
		RobotParameters.rightRateGains.kI = SmartDashboard.getNumber("rI", 0);
		RobotParameters.leftRateGains.kD = SmartDashboard.getNumber("lD", 0);
		RobotParameters.rightRateGains.kD = SmartDashboard.getNumber("rD", 0);
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
