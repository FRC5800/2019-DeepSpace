package frc.robot.base.commands.autonomous;

import frc.robot.base.commands.autonomous.routines.CommandMoveTime;
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
		autonomous[1] = (Autonomous) new Autonomous().setSequential(new CommandMoveTime(0.5, 3));
	}
}
