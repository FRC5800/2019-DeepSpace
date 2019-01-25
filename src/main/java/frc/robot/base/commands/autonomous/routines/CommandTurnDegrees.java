package frc.robot.base.commands.autonomous.routines;

import frc.robot.superclasses.Command5800;

public class CommandTurnDegrees extends Command5800 {
	int degreesToTurn;
	double startingDegrees;

	double speed;
	double leftValue;
	double rightValue;

	int turnDirection; // 1 for left, 0 for right

	boolean done = false;

	public CommandTurnDegrees(int degrees, double speed) {
		super(driver);
		this.speed = speed;
		this.startingDegrees = sensors.getChassiAngle();
		this.degreesToTurn = degrees;
	}

	@Override
	protected void onStart() {
		if (this.degreesToTurn < 0) {
			this.turnDirection = 1;
			this.leftValue = -this.speed;
			this.rightValue = this.speed;
		} else if (this.degreesToTurn > 0) {
			this.turnDirection = 0;
			this.leftValue = this.speed;
			this.rightValue = -this.speed;
		}
	}

	@Override
	protected void execute() {
		if (this.turnDirection == 1) {
			if (sensors.getChassiAngle() > ((this.degreesToTurn + this.startingDegrees) * 0.97)) {
				driver.tankDrive(this.leftValue, this.rightValue);
			} else if (sensors.getChassiAngle() < ((this.degreesToTurn + this.startingDegrees) * 1.03)) {
				driver.tankDrive(-this.leftValue, -this.rightValue);
			} else {
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				if (sensors.getChassiAngle() < ((this.degreesToTurn + this.startingDegrees) * 0.97)
						& sensors.getChassiAngle() > ((this.degreesToTurn + this.startingDegrees) * 1.03)) {
					this.done = true;
				} else {
					this.speed -= 0.035;
					if (this.speed < 0.3) {
						this.speed = 0.3;
					}
					this.leftValue = -this.speed;
					this.rightValue = this.speed;
				}
			}
		} else if (this.turnDirection == 0) {
			if (sensors.getChassiAngle() < ((this.degreesToTurn + this.startingDegrees) * 0.95)) {
				driver.tankDrive(this.leftValue, this.rightValue);
			} else if (sensors.getChassiAngle() > ((this.degreesToTurn + this.startingDegrees) * 1.05)) {
				driver.tankDrive(-this.leftValue, -this.rightValue);
			} else {
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				if (sensors.getChassiAngle() > ((this.degreesToTurn + this.startingDegrees) * 0.95)
						& sensors.getChassiAngle() < ((this.degreesToTurn + this.startingDegrees) * 1.05)) {
					this.done = true;
				} else {
					this.speed -= 0.035;
					if (this.speed < 0.3) {
						this.speed = 0.3;
					}
					this.leftValue = this.speed;
					this.rightValue = -this.speed;
				}
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
