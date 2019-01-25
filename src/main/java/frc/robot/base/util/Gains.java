/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.base.util;

/**
 * Add your docs here.
 */
public class Gains {
    public double kP, kI, kD, kF;

    public Gains(double P, double I, double D, double F){
        kP = P;
        kI = I;
        kD = D;
        kF = F;
    }
}
