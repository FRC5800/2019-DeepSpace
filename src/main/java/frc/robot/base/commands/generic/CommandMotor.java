package frc.robot.base.commands.generic;

import frc.robot.superclasses.Command5800;
import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.VictorSP;

public class CommandMotor extends Command5800 {
	public VictorSP motor;
	public double speed;

	public CommandMotor(Subsystem5800 requiredSubsystem, VictorSP motor, double speed) {
		super(requiredSubsystem);
		this.motor = motor;
		this.speed = speed;
	}

	@Override
	protected void execute() {
		this.motor.set(this.speed);
	}

	@Override
	protected boolean isDone() {
		return false;
	}

	@Override
	protected void onCompletion() {
		this.motor.set(0);
	}
}
