package frc.robot.base.subsystems;

import static frc.robot.RobotMap.*;
import frc.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.VictorSP;;

public class SubsystemCargoIntake extends Subsystem5800{

    public double speed;
    public boolean direction;
    
    public VictorSP motorLeft = new VictorSP(CARGO_MOTOR_LEFT_ID);
    public VictorSP motorRight = new VictorSP(CARGO_MOTOR_RIGHT_ID);

    public SubsystemCargoIntake(){
        super();
    }

    public void onInit(){
        motorRight.setInverted(true);
        motorLeft.setInverted(false);
    }
    public void cargoIntake(boolean dr, double sp){
        motorLeft.set(sp * (dr ? -1 : 1));
        motorRight.set(sp * (dr ? -1 : 1));
    }
}