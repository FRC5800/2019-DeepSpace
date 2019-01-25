package frc.robot.base.commands.autonomous.routines;

import frc.robot.superclasses.Command5800;

public class CommandTurnPulses extends Command5800 {
	int pulsesToTurn;
	double startingPulses;
	double speed;

	public CommandTurnPulses(int pulses, double speed) {
		super(driver);
		this.startingPulses = sensors.getChassiPulses('L');
		this.pulsesToTurn = pulses;
		this.speed = speed;
	}

	@Override
	protected void onStart() {
		sensors.reset();
	}

	@Override
	protected void execute() {
		driver.tankDrive(speed, -speed);
	}

	@Override
	protected boolean isDone() {
		return Math.abs(sensors.getChassiPulses('L')) > (this.pulsesToTurn + this.startingPulses);
	}

	@Override
	protected void onCompletion() {
	}
}
