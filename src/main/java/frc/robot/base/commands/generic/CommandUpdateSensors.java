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
		SmartDashboard.putNumber("kP", RobotParameters.positionGains.kP);
		SmartDashboard.putNumber("kI", RobotParameters.positionGains.kI);
		SmartDashboard.putNumber("kD", RobotParameters.positionGains.kD);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Gyro", CommandBase.sensors.getChassiAngle());
		SmartDashboard.putNumber("Distance Encoder L", CommandBase.sensors.driveEncoderL.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Distance Encoder R", CommandBase.sensors.driveEncoderR.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Error", CommandBase.driver.controllerLeft.getError());
		SmartDashboard.putNumber("Speed", CommandBase.driver.gearLeft.get());

		RobotParameters.positionGains.kP = SmartDashboard.getNumber("kP", 0);
		RobotParameters.positionGains.kI = SmartDashboard.getNumber("kI", 0);
		RobotParameters.positionGains.kD = SmartDashboard.getNumber("kD", 0);

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
