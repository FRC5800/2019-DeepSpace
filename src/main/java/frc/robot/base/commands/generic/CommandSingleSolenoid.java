package frc.robot.base.commands.generic;

import frc.robot.superclasses.Command5800;
import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.Solenoid;

public class CommandSingleSolenoid extends Command5800 {
	public Solenoid solenoid;
	public boolean status;

	public CommandSingleSolenoid(Subsystem5800 requiredSubsystem, Solenoid sol, boolean status) {
		super(requiredSubsystem);
		this.solenoid = sol;
		this.status = status;
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isDone() {
		return true;
	}

	@Override
	protected void onCompletion() {
		this.solenoid.set(this.status);
	}
}
