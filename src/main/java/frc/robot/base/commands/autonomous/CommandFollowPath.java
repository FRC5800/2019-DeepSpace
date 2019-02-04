package frc.robot.base.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.base.util.FalconPathPlanner;
import frc.robot.base.util.Path;
import frc.robot.superclasses.Command5800;

public class CommandFollowPath extends Command5800{
    int path, currentTime;
    double totalTime, initTime;
    FalconPathPlanner falconPath;
    
    public CommandFollowPath(int _path, double _totalTime){
        super(driver);
        this.path = _path;
        this.totalTime = _totalTime;
    }

    @Override
    protected void onStart(){
        falconPath = Path.pathCalculate(this.path, this.totalTime);
        initTime = Timer.getFPGATimestamp();
        driver.on();
    }

    protected void execute(){
        currentTime = (int)((Timer.getFPGATimestamp() - initTime) * 10);
        double _leftSpeed = falconPath.smoothLeftVelocity[currentTime][1];
        double _rightSpeed = falconPath.smoothRightVelocity[currentTime][1];
        driver.velocityPID(_leftSpeed, _rightSpeed);
    }

    protected boolean isDone(){
        return sensors.resetPID || currentTime == falconPath.smoothCenterVelocity.length-1;
    }

    protected void onCompletion(){
        driver.off();
        sensors.resetPID = false;
    }
}
