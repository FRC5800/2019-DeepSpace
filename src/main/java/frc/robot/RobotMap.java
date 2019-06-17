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
	DRIVE_MOTOR_FR_ID = 0,
	DRIVE_MOTOR_RR_ID = 1, 
	DRIVE_MOTOR_FL_ID = 2, 
	DRIVE_MOTOR_RL_ID = 3,
	CARGO_MOTOR_LEFT_ID = 4,
	CARGO_MOTOR_RIGHT_ID = 5,
	HATCH_MOTOR_ID = 6;

	/* CAN TalonSRX (0 - 63) */
	public static final int
	LIFT_MOTOR_ID = 0,
	LIFT_MOTOR_2_ID = 3;

	/* Solenoid (0 - 7) */
	public static final int 
	HATCH_SOLENOID_ID = 0;

	/* Digital I/Os (0 - 9) */
	public static final int
	DRIVE_ENCODER_R1_ID = 0, 
	DRIVE_ENCODER_R2_ID = 1, 
	DRIVE_ENCODER_L1_ID = 2,
	DRIVE_ENCODER_L2_ID = 3,
	HATCH_LIMITSWITCH_UP_ID = 4,
	HATCH_LIMITSWITCH_DOWN_ID = 5;
}