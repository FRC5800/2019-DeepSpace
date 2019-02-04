package frc.robot.base.util;

import frc.robot.base.util.FalconPathPlanner;
import java.awt.Color;
import java.awt.GraphicsEnvironment;

public class Path {
    public static final int P_CARGOBAY_1 = 0;
    
    private static double[][] p_cb_1 = {
        {0, 2},
        {2, 2}
    };

    public static final FalconPathPlanner[] _paths = {new FalconPathPlanner(p_cb_1)};
    
    public static FalconPathPlanner pathCalculate(int path, double totalTime){
        _paths[path].calculate(totalTime, 0.1, 2.3);
        return _paths[path];
    }

    public static void main(String args[]){
        _paths[P_CARGOBAY_1].calculate(2, 0.1, 2.4);

        if(!GraphicsEnvironment.isHeadless()){
            FalconLinePlot fig2 = new FalconLinePlot(_paths[P_CARGOBAY_1].smoothCenterVelocity,null,Color.blue);
                fig2.yGridOn();
                fig2.xGridOn();
                fig2.setYLabel("Velocity (ft/sec)");
                fig2.setXLabel("time (seconds)");
                fig2.setTitle("Velocity Profile for Left and Right Wheels \n Left = Cyan, Right = Magenta");
                fig2.addData(_paths[P_CARGOBAY_1].smoothRightVelocity, Color.magenta);
                fig2.addData(_paths[P_CARGOBAY_1].smoothLeftVelocity, Color.cyan);
        }
    }
}
