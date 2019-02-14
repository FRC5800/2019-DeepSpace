package frc.robot;

//import frc.robot.base.commands.autonomous.Autonomous;
import frc.robot.base.commands.teleoperated.*;
import frc.robot.base.commands.drive.*;
import frc.robot.base.commands.CommandBase;
import frc.robot.base.commands.CommandInterruptCommand;
import frc.robot.base.subsystems.SubsystemJoystick;

public class OI {
	public OI() {
		//Autonomous.initAutonomous();
	
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandHatchIntake());
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_B, new CommandArmSetMotor(-0.7));
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_Y, new CommandArmSetMotor(0.7));
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_A, new CommandArmSetMotor(0));
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandArm(0));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_Y, new CommandArm(5));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_B, new CommandReset());
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_LT, new CommandCargoIntake());
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_RT, new CommandCargoOuttake());
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_A, new CommandHatchIntakeMotor(0.4));
		
	}
}