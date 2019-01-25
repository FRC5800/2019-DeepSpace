package frc.robot;

import frc.robot.base.util.Converter;

/**
 * The RobotParameters is a mapping of all mechanical and electronic variables
 * of the robot. Declaring these values here makes easier to update the code
 * when some parameters is changed and reduces the number of magic numbers
 * floating around. All values must be declared in meters, any other unity or
 * measurement system will cause calculation errors.
 */
public class RobotParameters {
	/* Drive Train */
	public static final double WHEEL_DIAMETER = 6 * Converter.RATIO_INCHES_METERS, WHEEL_BASE = 0.65;

	/* Sensors */
	public static final double ENCODER_RESOLUTION = 1440;
}