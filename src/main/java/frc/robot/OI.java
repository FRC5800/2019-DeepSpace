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
	
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_A, new CommandArmLift(200, 0));
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_B, new CommandArmLift(1500, 0));
		CommandBase.joystick.whenPressed(SubsystemJoystick.d_B, new CommandArmLift(1500, 5000));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_B, new CommandReset());
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_POV_D, new CommandHatchMotor(true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_Thumb, new CommandIntake(true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_POV_U, new CommandHatchMotor(false));
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_Fire, new CommandIntake(false));

		//PID Buttons
		/*CommandBase.joystick.whenPressed(SubsystemJoystick.j_Seven, new CommandLift(1235)
		.setSequential(new CommandArm(1111))); //Cargo1
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Eight, new CommandLift(17500)
		.setSequential(new CommandArm(1380))); //Cargo2
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Nine, new CommandLift(16711)
		.setSequential(new CommandArm(3461))); //Cargo3
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Ten, new CommandLift(3785)
		.setSequential(new CommandArm(300))); //Hatch1
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Eleven, new CommandLift(18500)
		.setSequential(new CommandArm(400))); //Hatch2
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Twelve, new CommandLift(17132)
		.setSequential(new CommandArm(3474))); //Hatch3
		*/
		
	}
}