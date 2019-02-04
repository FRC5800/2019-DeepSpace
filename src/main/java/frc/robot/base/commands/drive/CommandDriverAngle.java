package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Command5800;

public class CommandDriverAngle extends Command5800 {

	double dist;
	double angle;

	public CommandDriverAngle(double angleTarget) {
		super(driver);
		
		this.dist = ((Math.PI * 71 / 36000 ) * angleTarget);
	}

	public void onStart() {
		CommandBase.sensors.reset();
		CommandBase.driver.anglePID(this.dist);
		CommandBase.driver.on();
	}

	protected void execute() {}

	protected boolean isDone() {
		return CommandBase.driver.onTarget() || sensors.resetPID;
	}

	protected void onCompletion() {
		CommandBase.driver.off();
		sensors.resetPID = false;
	}

}
