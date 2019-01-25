package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.Command5800;

public class CommandDrive extends Command5800 {

	double arcadeSpeed, arcadeRotation;
	double minR = 0.4D, difR = 0.5D;
	
	public CommandDrive() {	
		super(CommandBase.driver);
	}

	protected void execute() {
		this.arcadeSpeed = - SubsystemJoystick.axis_d_LY.get();
		this.arcadeRotation = SubsystemJoystick.axis_d_RX.get();

		this.arcadeDrive(this.arcadeSpeed, this.arcadeRotation);
	}
	
	protected boolean isDone() {
		return false;
	}
	protected void arcadeDrive(double speed, double rotation){
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;
		
		CommandBase.driver.velocityPID(speed * 15, rate * 15);
	}

	protected void onCompletion() {
	}


}
