package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.Solenoid;

public class SubsystemHatchIntake extends Subsystem5800{

  public boolean status = true;
  public boolean state = true;

  //Código para teste de dois solenoid, não oficial do hatchIntake
    public Solenoid hatchIntakeSolenoid = new Solenoid(HATCH_SOLENOID_ID);

    public SubsystemHatchIntake(){
        super();
    }

    public void hatchIntake(boolean state){
      this.hatchIntakeSolenoid.set(state);
    }
}