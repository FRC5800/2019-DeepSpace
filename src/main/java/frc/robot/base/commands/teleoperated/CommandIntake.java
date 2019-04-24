package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.base.commands.teleoperated.CommandHatchMotor;
import frc.robot.superclasses.*;

public class CommandIntake extends Command5800 {
  public boolean status;
  public boolean joyStatus;

  public CommandIntake(boolean _st, boolean joy_st){
      super(CommandBase.intake);
      status = _st;
      joyStatus = joy_st;
  }

  protected void onStart(){}

  protected void execute(){
    if (joyStatus || CommandBase.armLift.status){
      if(!CommandBase.intake.status){
        if(this.status){
          CommandBase.intake.cargoIntakeSet(0.4);
        } else {
          CommandBase.intake.cargoIntakeSet(-0.4);
        }
      } else {
        CommandBase.intake.hatchIntake(true);
        CommandBase.intake.cargoIntakeSet(0);
      }
    }
      
    
  }

  protected boolean isDone(){
    return false;
  }

  protected void onCompletion(){
    if (this.status){
      CommandBase.intake.cargoIntakeSet(0.15);
    } else {
      CommandBase.intake.cargoIntakeSet(0);
    }
    CommandBase.intake.hatchIntake(false);
  }
}