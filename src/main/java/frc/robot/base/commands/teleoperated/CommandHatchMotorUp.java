package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandHatchMotorUp extends Command5800 {

    public static boolean isDone;
    public double _sp;

    public CommandHatchMotorUp(double speed){     
     super(CommandBase.hatchIntake);
        _sp = speed;
    }

    protected void execute(){
        hatchIntake.hatchMotor(this._sp);
    }
    protected boolean isDone(){
     return false; 
         
    } 
    
    protected void onCompletion(){
      CommandBase.hatchIntake.hatchMotor(0.15);
     
    }
}