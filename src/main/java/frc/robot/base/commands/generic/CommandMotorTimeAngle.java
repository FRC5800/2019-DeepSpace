package frc.robot.base.commands.generic;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Command5800;
import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.VictorSP;

public class CommandMotorTimeAngle extends Command5800 {
	public VictorSP motor;
	public double speed;

	public CommandMotorTimeAngle(Subsystem5800 requiredSubsystem,  double speed, double time) {
		super(requiredSubsystem);
		setTimeout(time);
		this.speed = speed;
	}

	@Override
	protected void execute() {
		CommandBase.driver.tankDrive(this.speed, -this.speed);
	}

	@Override
	protected boolean isDone() {
		return isTimedOut();
	}

	@Override
	protected void onCompletion() {
		this.speed = 0;
	}
}
