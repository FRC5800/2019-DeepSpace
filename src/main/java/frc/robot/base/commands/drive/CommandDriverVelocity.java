package frc.robot.base.commands.drive;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.Command5800;

public class CommandDriverVelocity extends Command5800 {

    double sp;

    public CommandDriverVelocity(double velocity) {
		super(driver);
		
        this.sp = velocity;
	}

    public void onStart(){
        sensors.reset();
        CommandBase.driver.velocityPID(this.sp, 0);
        CommandBase.driver.on();
    }

    protected void execute() {}

    protected boolean isDone() {
		return CommandBase.sensors.velocityPID; 
    }
    
	protected void onCompletion() {
		CommandBase.driver.off();
	}
}
