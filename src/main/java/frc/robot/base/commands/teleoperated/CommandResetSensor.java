package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandResetSensor extends Command5800{

    public double speed;
    public CommandResetSensor(){
        super(CommandBase.armLift);
    }
      
    protected void execute(){;
        armLift.armMotor.setSelectedSensorPosition(0);
        //armLift.liftMotor.setSelectedSensorPosition(0);
        
    }
    
    protected boolean isDone(){
        return true;
    }
    
    protected void onCompletion(){
    }
}
