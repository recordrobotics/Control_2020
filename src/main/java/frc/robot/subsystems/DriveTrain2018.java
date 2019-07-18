/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain2018 extends DriveTrain {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  public void initDefaultCommand(){};
  //  {
  //   // Set the default command for a subsystem here.
  //   // setDefaultCommand(new MySpecialCommand());
  // }

  public boolean moveLeftWheels(double distance){
    return true;
  }
  public boolean moveRightWheels(double distance){
    return true;
  }
  public double getRightEncoder(){
    return 0.0;
  }
  public double getLeftEncoder(){
    return 0.0;
  }
}
