package frc.robot.base.commands;

import java.util.ArrayList;

import frc.robot.OI;
import frc.robot.base.commands.drive.CommandDriver;
import frc.robot.base.commands.generic.CommandUpdateSensors;
import frc.robot.base.commands.teleoperated.*;
import frc.robot.base.subsystems.*;
import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {
	public static OI oi;

	public static ArrayList<Subsystem5800> subsystemList = new ArrayList<Subsystem5800>();

	// Do not remove. Is used to set up each subsystem.
	public static int id = 0;

	// Create an instance of each subsystem here.
	public static SubsystemSensors sensors = new SubsystemSensors();
	public static SubsystemJoystick joystick = new SubsystemJoystick();
	public static SubsystemDriver driver = new SubsystemDriver();
	public static SubsystemArmLift armLift = new SubsystemArmLift();
	public static SubsystemIntake intake = new SubsystemIntake();

	public static void init() {
		sensors.setDefCommand(new CommandUpdateSensors());
		driver.setDefCommand(new CommandDriver());
		armLift.setDefCommand(new CommandArm());

		// Don't move or change this. EVER.
		oi = new OI();

		// Calls the method in SubsystemSensors that starts all sensors. Do not remove.
		sensors.init();

		// Adds information from all subsystems to the dashboard
		for (int a = 0; a < subsystemList.size(); a++) {
			SmartDashboard.putData(subsystemList.get(a));
		}
		SmartDashboard.putNumber("Number of subsystems", id);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
