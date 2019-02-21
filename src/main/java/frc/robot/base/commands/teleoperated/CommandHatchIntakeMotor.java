package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandHatchIntakeMotor extends Command5800 {

    public static boolean isDone;
    public double _sp;

    public CommandHatchIntakeMotor(double speed){     
     super(CommandBase.hatchIntake);
        _sp = speed;
    }
    
    protected void execute(){
      if (hatchIntake.status){
        hatchIntake.hatchMotor(_sp);
      }
      if (!hatchIntake.status){
        hatchIntake.hatchMotor(_sp);
      }
    }
    protected boolean isDone(){
     return false; 
         
    } 
    
    protected void onCompletion(){
      CommandBase.hatchIntake.hatchMotor(0.1);
      CommandBase.hatchIntake.status = !CommandBase.hatchIntake.status;
    }
}