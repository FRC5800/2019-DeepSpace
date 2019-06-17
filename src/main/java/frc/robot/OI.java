package frc.robot;

//import frc.robot.base.commands.autonomous.Autonomous;
import frc.robot.base.commands.teleoperated.*;
import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;

public class OI {
	public OI() {
		//Autonomous.initAutonomous();
	
		//CommandBase.joystick.whenPressed(SubsystemJoystick.j_Thumb, new CommandResetSensor());
		//CommandBase.joystick.whenPressed(SubsystemJoystick.j_Three, new CommandLift(0));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.j_Four, new CommandLift(15000));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_LB, new CommandIntake(true, true));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_LB, new CommandIntake(false, true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_Thumb, new CommandIntake(true, true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_Fire, new CommandIntake(false, true));		
	}
}