package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.Command5800;

public class CommandDriver extends Command5800 {

	double driverLimit;
	double arcadeSpeed, arcadeRotation;
	double minR = 0.4D, difR = 0.5D;
	
	public CommandDriver() {	
		super(CommandBase.driver);
	}

	protected void execute() {
		this.arcadeSpeed = - SubsystemJoystick.axis_d_LY.get();
		this.arcadeRotation = SubsystemJoystick.axis_d_RX.get();

		if (CommandBase.armLift.liftMotor.getSelectedSensorPosition() >= 10000 && CommandBase.armLift.armMotor.getSelectedSensorPosition() >= 3000){
			this.driverLimit = 0.35;
		} else {
			this.driverLimit = 0.7;
		}

		this.arcadeDrive(this.arcadeSpeed, this.arcadeRotation);
	}
	
	protected boolean isDone() {
		return false;
	}
	protected void arcadeDrive(double speed, double rotation){
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;

		CommandBase.driver.tankDrive(this.driverLimit * (speed - rate), 0.95 * this.driverLimit * (speed + rate), 0.05);

	}
	protected void onCompletion() {
	}
}
