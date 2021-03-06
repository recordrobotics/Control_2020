/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class BallUpOne extends Command {
  public BallUpOne() {
    // Use requires() here to declare subsystem dependencies
  }
  private int highestSlot, targetSlot, ballCount;
  private double beltSpeed = 0.4;
  private double moveTime = 0.1;
  private Boolean hitSlot;


  private Timer ballTimer = new Timer();

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ballTimer.start();

    highestSlot = Robot.belt.highestFullSlot();

    if(highestSlot == 3){
      targetSlot = 3;
    }
    else if(highestSlot != 0){
      targetSlot = highestSlot+1;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override 
  protected void execute() {
    Robot.belt.moveBelt(beltSpeed);
    Robot.acq.moveAcq(0.9);
    ballCount = Robot.belt.countBall();
    hitSlot = Robot.belt.getSlot(targetSlot-1);
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // Last or is emergency shutoff so the command will stop running in case of a ball getting stuck
    return (ballTimer.get() > moveTime && hitSlot)
     || (ballTimer.get() > 1);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
