package frc.robot.base.commands.teleoperated;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.base.commands.CommandBase;
import frc.robot.superclasses.*;

public class CommandArm extends Command5800 {
    double dis;
    
    public CommandArm(double _dis){
        super(CommandBase.armLift);
        dis = _dis;
    }
    
    protected void onInit(){
      CommandBase.armLift.armMotor2.setInverted(true);
    }

    protected void execute(){
        CommandBase.armLift.positionPIDArm(dis);

    }

    protected boolean isDone(){
        return CommandBase.sensors.sla;
    }

    protected void onCompletion(){
        CommandBase.sensors.sla = false;
        CommandBase.armLift.setArmMotor(0);
    }
}