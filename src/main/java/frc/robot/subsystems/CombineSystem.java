// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CombineSystem extends CommandBase {

  private PWMTalonSRX combineMotor;

  /** Creates a new Combine. */
  public CombineSystem() {
    // Use addRequirements() here to declare subsystem dependencies.

    combineMotor = new PWMTalonSRX(5);

    

  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

public void setSpeed(double speed){
  combineMotor.set(speed);
}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
