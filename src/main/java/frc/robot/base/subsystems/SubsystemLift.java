package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemLift extends Subsystem5800{
    public VictorSP armMotor = new VictorSP(ARM_MOTOR_ID);
    
    public SubsystemLift(){
        super();
    }
    
    @Override
    public void onInit(){
        armMotor.set(0.15);
    }

    public void setMotor(double speed){
        armMotor.set(speed);
    }
}