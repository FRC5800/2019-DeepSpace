/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.base.util.PIDType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * Add your docs here.
 */ 
public class PIDSensor implements PIDSource {
    private Encoder e_sensor;
    private ADXRS450_Gyro g_sensor;
    private int inPhase = 1;
    private PIDSourceType type = PIDSourceType.kRate;
    public PIDType mode = PIDType.kPosition;

    public PIDSensor(Encoder sensor1, ADXRS450_Gyro sensor2){
        e_sensor = sensor1;
        g_sensor = sensor2;
    }

    public void inPhase(int _p){
        this.inPhase = _p;            
    }

    @Override 
    public PIDSourceType getPIDSourceType() {
        return type;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        type = pidSource;
    }

    @Override
    public double pidGet(){
        switch (mode){
            case kPosition: return e_sensor.getRaw()*this.inPhase;
            case kAngle: return g_sensor.getAngle()*this.inPhase;
            case kRate: return e_sensor.getRate()*this.inPhase;
            default: return 0.0;
        }
    }

}
