package frc.robot.base.commands.autonomous.routines;

import frc.robot.superclasses.Command5800;

public class CommandMoveTime extends Command5800 {
	double speed;
	double time;

	boolean done = false;

	public CommandMoveTime(double speed, double time) {
		super(driver);
		setTimeout(time);
		this.speed = speed;
		this.time = time;
	}

	@Override
	protected void onStart() {
	}

	@Override
	protected void execute() {
		driver.tankDrive(this.speed, this.speed);
	}

	@Override
	protected boolean isDone() {
		return isTimedOut();
	}

	@Override
	protected void onCompletion() {
	}
}