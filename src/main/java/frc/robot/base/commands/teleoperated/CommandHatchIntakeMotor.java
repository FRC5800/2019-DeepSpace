package frc.robot.base.commands.teleoperated;

import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandHatchIntakeMotor extends Command5800 {

    public boolean limitSwitchStateUp =  CommandBase.sensors.statusLimitSwitch('U');
    public boolean limitSwitchStateDown =  CommandBase.sensors.statusLimitSwitch('D');


    public CommandHatchIntakeMotor(double speed){     
     super(CommandBase.hatchIntake);
    }
    
    protected void execute(){
      if (this.limitSwitchStateUp == true){
        CommandBase.hatchIntake.hatchMotor(-0.4);
      }else if (this.limitSwitchStateDown == true){
        CommandBase.hatchIntake.hatchMotor(0.4);
      }
    }


    protected boolean isDone(){
      return this.limitSwitchStateDown || this.limitSwitchStateUp;
    }
    
    protected void onCompletion(){
      CommandBase.hatchIntake.hatchMotor(0.0);
    }
}