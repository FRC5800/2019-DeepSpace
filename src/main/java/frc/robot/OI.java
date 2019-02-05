package frc.robot;

//import frc.robot.base.commands.autonomous.Autonomous;
import frc.robot.base.commands.teleoperated.*;
import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;

public class OI {
	public OI() {
		//Autonomous.initAutonomous();
	
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandDoubleSolenoidActive());
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandDoubleSolenoidReverse());
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandDoubleSolenoidOff());
		//CommandBase.joystick.whenHeld(SubsystemJoystick.d_A, new CommandLift(0.7));
		//CommandBase.joystick.whenHeld(SubsystemJoystick.d_B, new CommandLift(-0.7));
		//CommandBase.joystick.whenHeld(SubsystemJoystick.d_LT, new CommandCargoIntake(0.4, true));
		//CommandBase.joystick.whenHeld(SubsystemJoystick.d_RT, new CommandCargoIntake(0.4, false));
		
	}
}