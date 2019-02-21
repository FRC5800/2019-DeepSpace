package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemHatchIntake extends Subsystem5800{

  public boolean status = true;
  public boolean state = true;
  public boolean onExecution = false;;

    public Solenoid hatchIntakeSolenoid = new Solenoid(HATCH_SOLENOID_ID);
    public VictorSP hatchIntakeMotor = new  VictorSP(HATCH_MOTOR_ID);

    public SubsystemHatchIntake(){
        super();
    }

    public void onInit(){
      this.hatchIntakeMotor.set(0.15);
    }

    public void hatchIntake(boolean state){
      this.hatchIntakeSolenoid.set(state);
    }

    public void hatchMotor(double speed){
      this.hatchIntakeMotor.set(speed);
    }
}