package frc.robot.base.commands.autonomous.routines;

import frc.robot.superclasses.Command5800;

public class CommandTurnTime extends Command5800 {
	double speed;

	public CommandTurnTime(double time, double speed) {
		super(driver);
		setTimeout(time);
		this.speed = speed;
	}

	@Override
	protected void execute() {
		driver.tankDrive(this.speed, -this.speed);
	}

	@Override
	protected boolean isDone() {
		return isTimedOut();
	}

	@Override
	protected void onCompletion() {
	}
}
