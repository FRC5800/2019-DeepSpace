package frc.robot;

import frc.robot.base.util.Converter;
import frc.robot.base.util.Gains;

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

	public static Gains positionGains = new Gains(0.5, 0, 0, 0);
	public static Gains rateGains = new Gains(0.5, 0, 0, 0);
	public static Gains angleGains = new Gains(0.5, 0, 0, 0);

	public static Gains armGains = new Gains(3.7, 0, 13, 0);
	public static Gains liftGains = new Gains(0.4, 0.00000043, 3.7, 0);
}