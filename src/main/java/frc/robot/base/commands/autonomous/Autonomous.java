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

		//hatch na cargoship saindo da posição 1 (esquerda), bay 1
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2.54),
				new CommandDriverAngle(-90),
				new CommandDriverPosition(0.508),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2.790952),
				new CommandDriverAngle(90),
				new CommandDriverPosition(0.6604)
				//colocar hatch
				);
		
		//hatch na cargoship saindo da posição 1 (esquerda), bay 2
		autonomous[2] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(0.508),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(3.302254),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(0.6604)
			    //colocar hatch
			    ); 
		
		//hatch na cargoship saindo da posição 1 (esquerda), bay 3
		autonomous[3] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(0.508),
			    new CommandDriverAngle(90),
		     	new CommandDriverPosition(3.813302),
		    	new CommandDriverAngle(90),
			    new CommandDriverPosition(0.6604));
			    //colocar hatch

		//hatch na cargoship saindo da posição 2, bay 1
		autonomous[4] = (Autonomous) new Autonomous().setSequential(
				new CommandDriverPosition(2.54),
				new CommandDriverAngle(-45),
				new CommandDriverPosition(2.316988),
				new CommandDriverAngle(45),
				new CommandDriverPosition(1.139952),
				new CommandDriverAngle(90),
				new CommandDriverPosition(0.6604)
					);

        //hatch na cargoship saindo da posição 2, bay 2
		autonomous[5] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(-45),
			    new CommandDriverPosition(2.316988),
			    new CommandDriverAngle(45),
			    new CommandDriverPosition(1.651),
		     	new CommandDriverAngle(90),
		    	new CommandDriverPosition(0.6604)
				);
		
		//hatch na cargoship saindo da posição 2, bay 3
		autonomous[6] = (Autonomous) new Autonomous().setSequential(
		     	new CommandDriverPosition(2.54),
		    	new CommandDriverAngle(-45),
			    new CommandDriverPosition(2.316988),
			    new CommandDriverAngle(45),
			    new CommandDriverPosition(2.162302),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(0.6604)
			    );
				

		//hatch na cargoship saindo da posição 3 (direita), bay 1
		autonomous[7] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(0.508),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(2.790952),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(0.6604)
			    //colocar hatch
			    );
	

		//hatch na cargoship saindo da posição 3 (direita), bay 2
		autonomous[8] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(0.508),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(3.302254),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(0.6604)
		     	//colocar hatch
		    	);
		//hatch na cargoship saindo da posição 3 (direita), bay 3
		autonomous[9] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(90),
			    new CommandDriverPosition(0.508),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(3.813302),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(0.6604)
			    //colocar hatch
			    );

		//hatch no rocket saindo da posição 1 (esquerda/blue, direita/red)
		autonomous[10] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1.988058),
				new CommandDriverAngle(61),
				new CommandDriverPosition(1.32715));

		//hatch no rocket saindo da posição 2 (meio)
		autonomous[11] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2),
		        new CommandDriverAngle(-90),
				new CommandDriverPosition(1),
				new CommandDriverAngle(90),
				new CommandDriverPosition(2));

		//hatch no rocket saindo da posição 3 (direita/blue, esquerda/red)
		autonomous[12] = (Autonomous) new Autonomous().setSequential(
			    new CommandDriverPosition(2.54),
			    new CommandDriverAngle(-90),
			    new CommandDriverPosition(1.988058),
			    new CommandDriverAngle(61),
			    new CommandDriverPosition(1.32715));
		


		
		

	
					
		
		
	
	}
}
