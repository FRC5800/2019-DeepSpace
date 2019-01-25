package frc.robot.base.util;

import frc.robot.RobotParameters;

public class Converter {
	/**
	 * Holds the conversion rate between inches and meters
	 */
	public static double RATIO_INCHES_METERS = 0.0254;

	public static double convertAngular(double input, char inputSelector) {
		double output = 0;
		if (inputSelector == 'D') {
			output = Math.toRadians(input);
		} else if (inputSelector == 'R') {
			output = Math.toDegrees(input);
		}
		return output;
	}

	public static double convertEncoder(double input, char inputSelector) {
		double output = 0;
		if (inputSelector == 'D') {
			output = (input * RobotParameters.ENCODER_RESOLUTION) / (RobotParameters.WHEEL_DIAMETER * Math.PI);
		} else if (inputSelector == 'P') {
			output = (input * (RobotParameters.WHEEL_DIAMETER * Math.PI) / RobotParameters.ENCODER_RESOLUTION);
		}
		return output;
	}

	public static double convertMetric(double input, char inputSelector) {
		double output = 0;
		if (inputSelector == 'C') {
			output = input / 100;
		} else if (inputSelector == 'M') {
			output = input * 100;
		}
		return output;
	}
}
