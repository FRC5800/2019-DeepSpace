package frc.robot;

//import frc.robot.base.commands.autonomous.Autonomous;
import frc.robot.base.commands.teleoperated.*;
import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;

public class OI {
	public OI() {
		//Autonomous.initAutonomous();
	
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Thumb, new CommandResetSensor());
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Eight, new CommandLiftArm(200, 0)); //inital position and hatch1
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Ten, new CommandArmLift(1000, 17000)); //hatch2
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Twelve, new CommandArmLift(3380, 15400)); //hatch3
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Three, new CommandLiftArm(0, 0)); //cargo0
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Four, new CommandArmLift(1250, 0)); //cargo1
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Five, new CommandArmLift(1590, 15500)); //cargo2
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Six, new CommandArmLift(3380, 15400)); //cargo3
		CommandBase.joystick.whenPressed(SubsystemJoystick.j_Eleven, new CommandManualArm()); //manche 
		CommandBase.joystick.whenHeld(SubsystemJoystick.j_Fire, new CommandIntake(false, false));
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_LB, new CommandHatchMotor(true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_LT, new CommandIntake(true, true));
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_RB, new CommandHatchMotor(false));
		CommandBase.joystick.whenHeld(SubsystemJoystick.d_RT, new CommandIntake(false, true));
		
		//Test elevator constants
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_Y, new CommandArmLift(200, 10000));
		//CommandBase.joystick.whenPressed(SubsystemJoystick.d_X, new CommandArmLift(200, 0));
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