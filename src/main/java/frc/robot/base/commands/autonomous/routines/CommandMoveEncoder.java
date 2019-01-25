package frc.robot.base.commands.autonomous.routines;

import frc.robot.superclasses.Command5800;

public class CommandMoveEncoder extends Command5800 {
	double pulsesToGo;

	double speed;
	double error;
	double parameter;

	int driveDirection; // 1 for forward, 0 for backward

	boolean done = false;

	public CommandMoveEncoder(int centimeters, double sp) {
		super(driver);
		this.pulsesToGo = (centimeters * 5);
		this.speed = sp;
	}

	@Override
	protected void onStart() {
		sensors.reset();
		if (this.pulsesToGo < 0) {
			this.driveDirection = 1;
			this.speed = -this.speed;
			this.parameter = -0.035;
		} else if (this.pulsesToGo > 0) {
			this.driveDirection = 0;
			this.parameter = 0.035;
		}
	}

	@Override
	protected void execute() {
		if (driveDirection == 0) {
			this.error = sensors.getChassiAngle();
			driver.tankDrive(this.speed - (this.error * this.parameter), this.speed + (this.error * this.parameter));
			if (Math.abs(sensors.getChassiPulses('L')) >= this.pulsesToGo * 0.825
					&& Math.abs(sensors.getChassiPulses('R')) >= this.pulsesToGo * 0.825) {
				this.speed -= 0.035;
				if (this.speed < 0.3) {
					this.speed = 0.3;
				}
			} else if (Math.abs(sensors.getChassiPulses('L')) >= this.pulsesToGo
					&& Math.abs(sensors.getChassiPulses('R')) >= this.pulsesToGo) {
				this.done = true;
			}
		} else if (this.driveDirection == 1) {
			this.error = sensors.getChassiAngle();
			driver.tankDrive(this.speed - (this.error * this.parameter), this.speed + (this.error * this.parameter));
			if (Math.abs(sensors.getChassiPulses('L')) <= this.pulsesToGo * 0.825
					&& Math.abs(sensors.getChassiPulses('R')) <= this.pulsesToGo * 0.825) {
				this.speed += 0.035;
				if (this.speed > -0.3) {
					this.speed = -0.3;
				}
			} else if (Math.abs(sensors.getChassiPulses('L')) <= this.pulsesToGo
					&& Math.abs(sensors.getChassiPulses('R')) <= this.pulsesToGo) {
				this.done = true;
			}
		}
	}

	@Override
	protected boolean isDone() {
		return this.done;
	}

	@Override
	protected void onCompletion() {
	}
}