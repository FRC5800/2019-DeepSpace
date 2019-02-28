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
		SmartDashboard.putNumber("Distance Encoder L",
				Converter.convertEncoder(CommandBase.sensors.getChassiPulses('L'), 'P'));
		SmartDashboard.putNumber("Speed Encoder L",
				Converter.convertEncoder(CommandBase.sensors.getChassiSpeed('L'), 'P'));
		SmartDashboard.putNumber("Distance Encoder R",
				Converter.convertEncoder(CommandBase.sensors.getChassiPulses('R'), 'P'));
		SmartDashboard.putNumber("Speed Encoder R",
				Converter.convertEncoder(CommandBase.sensors.getChassiSpeed('R'), 'P'));
		SmartDashboard.putBoolean("Status", CommandBase.armLift.armOnTarget(0.1));
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	@Override
	protected void onCompletion() {
	}
}
