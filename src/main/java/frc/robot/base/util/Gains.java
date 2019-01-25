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
