package frc.robot.base.commands.autonomous;

import frc.robot.base.commands.drive.CommandDriverAngle;
import frc.robot.base.commands.drive.CommandDriverPosition;
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

		//hatch na cargoship saindo da posição 1, bay 1
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2),
				new CommandDriverAngle(90),
				new CommandDriverPosition(1)
				);
		
		//hatch na cargoship saindo da posição 1, bay 2
		autonomous[2] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(90),
				new CommandDriverPosition(1)); 
		
		//hatch na cargoship saindo da posição 1, bay 3
		autonomous[3] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(90),
				new CommandDriverPosition(1));

		//hatch na cargoship saindo da posição 2, bay 1
		autonomous[4] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2),
				new CommandDriverAngle(90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2),
				new CommandDriverAngle(-90),
				new CommandDriverPosition(1)
					);

        //hatch na cargoship saindo da posição 2, bay 2
		autonomous[5] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2),
				new CommandDriverAngle(90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2),
				new CommandDriverAngle(-90),
				new CommandDriverPosition(1)
						);
		
		//hatch na cargoship saindo da posição 2, bay 3
		autonomous[6] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2),
				new CommandDriverAngle(90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2),
				new CommandDriverAngle(-90),
				new CommandDriverPosition(1)
						);

		//hatch na cargoship saindo da posição 3, bay 1
		autonomous[7] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1));

		//hatch na cargoship saindo da posição 3, bay 2
		autonomous[8] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1));

		//hatch na cargoship saindo da posição 3, bay 3
		autonomous[9] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1));

		//hatch no rocket saindo da posição 1
		autonomous[10] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90));

		//hatch no rocket saindo da posição 2
		autonomous[11] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2));

		//hatch no rocket saindo da posição 3
		autonomous[12] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(-90));

		


		
		

	
					
		
		
	
	}
}
