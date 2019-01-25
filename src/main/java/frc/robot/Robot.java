package frc.robot;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.commands.autonomous.Autonomous;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	public static boolean isAuto;

	/**
	 * This function is called when the robot is first initialized
	 */
	public void robotInit() {
		CommandBase.init(); // This initializes all subsystems
		CommandBase.sensors.init();
		SmartDashboard.putNumber("Autonomous Version", 0);
	}

	/**
	 * This function is called when the autonomous is started
	 */
	public void autonomousInit() {
		/* This sets the command used to begin the autonomous sequence */
		int av = (int) SmartDashboard.getNumber("Autonomous Version", 1);
		SmartDashboard.putNumber("Autonomous Version", av);
		/* This starts the autonomous sequence. */
		CommandBase.sensors.reset();
		Autonomous.autonomous[av].start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		isAuto = isAutonomous();
	}

	/**
	 * This function is called when the operator control mode is started
	 */
	public void teleopInit() {
		int i = 0;
		for (i = 0; i < Autonomous.autonomous.length; i++) {
			if (Autonomous.autonomous[i] != null) {
				System.out.println("Command cancelled");
				Autonomous.autonomous[i].cancel();
			}
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		isAuto = isAutonomous();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}

}
