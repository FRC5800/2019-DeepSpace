package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.Command5800;

public class CommandDrive extends Command5800 {
	double arcadeSpeed;
	double arcadeRotation;

	public static final double minR = 0.4D, difR = 0.5D;

	public CommandDrive() {
		super(CommandBase.driver);
	}

	@Override
	protected void execute() {
		this.arcadeSpeed = -0.75 * SubsystemJoystick.axis_d_LY.get();
		this.arcadeRotation = SubsystemJoystick.axis_d_RX.get();
		CommandBase.driver.arcadeDrive(this.arcadeSpeed, this.arcadeRotation);
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	public void arcadeDrive(double speed, double rotation) {
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;
		CommandBase.driver.tankDrive(-(speed + rate), rate - speed);
	}

	@Override
	protected void onCompletion() {
	}
}
