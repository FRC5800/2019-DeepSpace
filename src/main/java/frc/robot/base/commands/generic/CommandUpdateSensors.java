package frc.robot.base.commands.generic;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.base.util.Converter;
import frc.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandUpdateSensors extends Command5800 {
	public CommandUpdateSensors() {
		super(CommandBase.sensors);
	}

	@Override
	public void onStart(){
		SmartDashboard.putNumber("Driver Modifier", 1);
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
		SmartDashboard.putNumber("Gear Right",CommandBase.driver.gearRight.get());
		SmartDashboard.putNumber("Gear Left",CommandBase.driver.gearLeft.get());
		SmartDashboard.putNumber("Speed Encoder R",
				Converter.convertEncoder(CommandBase.sensors.getChassiSpeed('R'), 'P'));
		SmartDashboard.putBoolean("Speed", CommandBase.armLift.armMotor.getSelectedSensorVelocity() < 5);
		SmartDashboard.putNumber("Arm Motor", CommandBase.armLift.armMotor.getMotorOutputPercent());
		SmartDashboard.putNumber("Arm Motor2", CommandBase.armLift.armMotor2.getMotorOutputPercent());
		SmartDashboard.putNumber("Arm Motor V", CommandBase.armLift.armMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Arm Motor V2", CommandBase.armLift.armMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("J", SubsystemJoystick.axis_j_Y.get());
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	@Override
	protected void onCompletion() {
	}
}
