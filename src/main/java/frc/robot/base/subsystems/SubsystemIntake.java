package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemIntake extends Subsystem5800{
  public boolean status = false;
 
  public VictorSP motorLeft = new VictorSP(CARGO_MOTOR_LEFT_ID);
  public VictorSP motorRight = new VictorSP(CARGO_MOTOR_RIGHT_ID);
  public Solenoid hatchIntakeSolenoid = new Solenoid(HATCH_SOLENOID_ID);
  public VictorSP hatchIntakeMotor = new  VictorSP(HATCH_MOTOR_ID);

  public SubsystemIntake(){
      super();
      motorRight.setInverted(true);
  }

  public void onInit(){
    this.hatchIntakeMotor.set(0.15);
    this.cargoIntakeSet(0.15);
  }

  public void cargoIntakeSet(double speed){
    motorLeft.set(speed);
    motorRight.set(speed);
  }

  public void hatchIntake(boolean state){
    this.hatchIntakeSolenoid.set(state);
  }

  public void hatchMotor(double speed){
    this.hatchIntakeMotor.set(speed);
  }
}