package frc.robot;

/**
 * The RobotMap is a mapping the ports sensors and actuators are wired into to a
 * variable name. This provides flexibility changing wiring, makes checking the
 * wiring easier and significantly reduces the number of magic numbers floating
 * around.
 */
public class RobotMap {
	/* PWMs (0 - 9) */
	public static final int 
	DRIVE_MOTOR_FL_ID = 0, 
	DRIVE_MOTOR_RL_ID = 1,
	DRIVE_MOTOR_FR_ID = 2,
	DRIVE_MOTOR_RR_ID = 3, 
	ARM_MOTOR_ID = 8,
	CARGO_MOTOR_LEFT_ID = 4,
	CARGO_MOTOR_RIGHT_ID = 5;

	/* Solenoid (0 - 7) */
	public static final int 
	SOLENOID_TEST_ONE_ID = 2,
	SOLENOID_TEST_TWO_ID = 1,
	SOLENOID_TEST_THREE_ID = 0;

	/* Digital I/Os (0 - 9) */
	public static final int
	DRIVE_ENCODER_R1_ID = 0, 
	DRIVE_ENCODER_R2_ID = 1, 
	DRIVE_ENCODER_L1_ID = 2,
	DRIVE_ENCODER_L2_ID = 3;
}