package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotController;
/**import edu.wpi.first.wpilibj.I2C.Port;*/
import frc.robot.Robot;

/**
 * Subsystem class for the gyroscope used on the 2020 Robot
 * Extends the Gyroscope abstract class
 */
public class Gyro2020 extends Gyroscope{
    @Override
    public void initDefaultCommand() {;
        /**do nothing, no default command for this subsystem*/
    }   
    /**
    * Instance variable representing the gyroscope, an AHRS gyroscope
    * @see RobotMap.java
    */
    private AHRS gyro = new AHRS(I2C.Port.kOnboard);

    
    /**
     * @return the current angle the robot is at, in degrees
     */
    public double getDeg(){
        if (Robot.isSimulation())
            return Robot.driveTrain.getSimulatedAngle();
        
        return gyro.getAngle();
    }

    /**
     * @return the current angle the robot is at, in radians
     */
    public double getRad(){
        return Math.toRadians(getDeg());
    }
    
    /**
     * Calibrates the gyroscope and resets the current direction the robot is pointing to 0
     * Don't move the robot for 5 seconds while the gyroscope is calibrating
     */
    public void gyroCalib(){
        gyro.calibrate();
        gyro.reset();
    }

    /**
     * Resets the current direction the robot is pointing to 0
     * Does not calibrate the robot!
     */
    public void gyroReset(){
        gyro.reset();
    }
}