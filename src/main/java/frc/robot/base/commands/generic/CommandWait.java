package frc.robot.base.commands.generic;

import frc.robot.superclasses.Command5800;

public class CommandWait extends Command5800 {
	public CommandWait(double timeout) {
		super(null);
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isDone() {
		return isTimedOut();
	}

	@Override
	protected void onCompletion() {
	}
}
