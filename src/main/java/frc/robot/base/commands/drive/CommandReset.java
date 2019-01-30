package frc.robot.base.commands.drive;

import frc.robot.superclasses.Command5800;

public class CommandReset extends Command5800 {

	public CommandReset() {
		super(null);
	}

	protected void execute() {
	}

	protected boolean isDone() {
		return true;
	}

	protected void onCompletion() {
		sensors.reset();
		driver.off();
		
	}

}
