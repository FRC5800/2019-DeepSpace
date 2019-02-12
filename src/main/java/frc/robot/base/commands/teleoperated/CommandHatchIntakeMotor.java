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
        if(CommandBase.hatchIntake.status){
          isDone = CommandBase.sensors.statusLimitSwitch('U');
        }
        if(!CommandBase.hatchIntake.status){
          isDone = CommandBase.sensors.statusLimitSwitch('D');
        } 
        return isDone;
    }
    
    protected void onCompletion(){
      CommandBase.hatchIntake.hatchMotor(0.0);
      CommandBase.hatchIntake.status = !CommandBase.hatchIntake.status;
    }
}