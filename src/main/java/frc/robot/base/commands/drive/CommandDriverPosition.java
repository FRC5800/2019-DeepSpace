package frc.robot.base.commands.drive;
import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Command5800;

public class CommandDriverPosition extends Command5800 {

	double targetPosition;

	public CommandDriverPosition(double targetPosition) {
		super(driver);
		this.targetPosition = targetPosition;
	}

	public void onStart() {
		CommandBase.sensors.reset();
		CommandBase.driver.positionPID(this.targetPosition);
		CommandBase.driver.off();
	} 

	protected void execute() {
	}

	protected boolean isDone() {
		return CommandBase.driver.onTarget();
	}

	protected void onCompletion() {
		CommandBase.driver.off();
	}
}
