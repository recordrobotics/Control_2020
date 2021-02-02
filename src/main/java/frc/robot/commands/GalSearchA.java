package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GalSearchA extends CommandGroup {

    private double velocity;
    private double initX = 0.5, initY = 2.3;
    private boolean redPath = true;

    

    public GalSearchA(){
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
        Robot.odometry.reset(initX, initY);
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);

        addParallel(new TiltAcquisition());
        if (redPath) {
            initX = 0.0;
            initY = 2.286;
            redPath();
        }
        else {
            initX = 1.15;
            bluePath();
        }
    }

    private void bluePath(){
    }

    private void redPath(){
        addSequential(new MoveForward(48, -0.7));
        
        addParallel(new PickUpBall());
        addSequential(new MoveForward(18, -0.4));

        addSequential(new CircularTrajectory(3, Math.PI/5, velocity));
        addParallel(new PickUpBall());
        
        addSequential(new CircularTrajectory(-0.5, Math.PI - 0.25, velocity*0.75));
/*        addSequential(new MoveForward(48, -0.7));

        addParallel(new PickUpBall());
        addSequential(new MoveForward(18, -0.4));
        addSequential(new CircularTrajectory(0.25, Math.PI/2 + 0.75, velocity));   
        
        addSequential(new CircularTrajectory(-14, Math.PI/10, velocity));
  */  
    }

    @Override
    protected void initialize() {
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);    
        Robot.odometry.reset(initX, initY);
    }

    @Override
    protected void execute() {
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
    }
    
}
