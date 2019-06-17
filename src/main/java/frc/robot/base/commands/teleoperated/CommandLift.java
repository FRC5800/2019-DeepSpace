package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.subsystems.SubsystemJoystick;
import frc.robot.superclasses.Command5800;

public class CommandLift extends Command5800 {

    int limit = 10000;
	double _sp;
	
	public CommandLift() {	
		super(CommandBase.lift);
	}

	protected void execute() {
        this._sp = SubsystemJoystick.axis_j_Y.get()*0.4;
        if (this._sp >= 0){
            if (CommandBase.lift.liftMotor.getSelectedSensorPosition() <= this.limit){
                CommandBase.lift.setLiftMotor(this._sp);
            } else {
                CommandBase.lift.setLiftMotor(0.1);
            }
        } if (this._sp < 0){
            if (CommandBase.lift.liftMotor.getSelectedSensorPosition() >= -this.limit){
                CommandBase.lift.setLiftMotor(this._sp);
            } else {
                CommandBase.lift.setLiftMotor(-0.1);
            }
        }
	}
	
	protected boolean isDone() {
		return false;
	}
	
	protected void onCompletion() {
	}
}
