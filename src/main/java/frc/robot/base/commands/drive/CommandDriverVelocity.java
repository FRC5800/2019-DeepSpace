package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Command5800;

public class CommandDriverVelocity extends Command5800 {

    double sp_l, sp_r;    

    public CommandDriverVelocity(double velocity_l, double velocity_r) {
		super(driver);
		
        this.sp_l = velocity_l;
        this.sp_r = velocity_r;
	}

    public void onStart(){
        sensors.reset();
        CommandBase.driver.velocityPID(this.sp_l, this.sp_r);
        CommandBase.driver.on();
    }

    protected void execute() {}

    protected boolean isDone() {
		return CommandBase.sensors.velocityPID || sensors.resetPID;
    }
    
	protected void onCompletion() {
        CommandBase.driver.off();
        sensors.resetPID = false;
	}
}
