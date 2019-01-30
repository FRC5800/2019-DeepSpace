package frc.robot.base.commands.generic;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.util.Converter;
import frc.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandUpdateSensors extends Command5800 {
	public CommandUpdateSensors() {
		super(CommandBase.sensors);
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Gyro", CommandBase.sensors.getChassiAngle());
		SmartDashboard.putNumber("Distance Encoder L", CommandBase.sensors.driveEncoderL.getRaw() * Math.PI * 15 / 144000);
		SmartDashboard.putNumber("Distance Encoder R", CommandBase.sensors.driveEncoderR.getRaw() * Math.PI * 15 / 144000);
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	@Override
	protected void onCompletion() {
	}
}
