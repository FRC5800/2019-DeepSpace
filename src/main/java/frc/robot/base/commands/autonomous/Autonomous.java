package frc.robot.base.commands.autonomous;

import frc.robot.base.commands.drive.CommandDriverAngle;
import frc.robot.base.commands.drive.CommandDriverPosition;
import frc.robot.base.commands.generic.CommandMotorTime;
import frc.robot.base.commands.generic.CommandMotorTimeAngle;
import frc.robot.base.commands.teleoperated.CommandIntake;
import frc.robot.superclasses.Command5800;

public class Autonomous extends Command5800 {
	public Autonomous() {
		super(null);
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
	}

	public static Autonomous[] autonomous = new Autonomous[12];

	public static void initAutonomous() {
		autonomous[0] = new Autonomous();

		//primeira rotina
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandMotorTime(driver, 0.6, 3),
				new CommandMotorTimeAngle(driver, 0.5, 2),
				new CommandIntake(false, true)
				);
	
	}
}
