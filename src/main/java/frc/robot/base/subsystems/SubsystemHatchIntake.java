package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;

import frc.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class SubsystemHatchIntake extends Subsystem5800{

  public boolean status = true;
  public boolean state = true;

  //Código para teste de dois solenoid, não oficial do hatchIntake
    public Solenoid testOne = new Solenoid(SOLENOID_TEST_ONE_ID);
    public DoubleSolenoid testTwo = new DoubleSolenoid(SOLENOID_TEST_TWO_ID, SOLENOID_TEST_THREE_ID);
    //public Solenoid testTwo = new Solenoid(SOLENOID_TEST_TWO_ID);
    //public Solenoid testThree = new Solenoid(SOLENOID_TEST_THREE_ID);

    public SubsystemHatchIntake(){
        super();
    }

    public void activeSolenoidOne(boolean state){
      this.testOne.set(state);
    }

    public void activeDoubleSolenoid(){
      this.testTwo.set(DoubleSolenoid.Value.kForward);
      //this.testTwo.set(true);  
      //this.testThree.set(true);  
    }

    public void disactiveDoubleSolenoid(){
      this.testTwo.set(DoubleSolenoid.Value.kOff);
      //this.testTwo.set(false);
      //this.testThree.set(false);

    }

    public void activeReverseDoubleSolenoid(){
      this.testTwo.set(DoubleSolenoid.Value.kReverse);
      //this.testTwo.set(true);
      //this.testTwo.set(false);
    }

    /*public void middleSolenoid(){
      this.testTwo.set(false);
      this.testThree.set(true);
    }*/
}