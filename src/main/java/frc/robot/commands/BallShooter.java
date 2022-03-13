// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingSystem;

public class BallShooter extends CommandBase {

  private final ShootingSystem m_shootingsystem;
  /** Creates a new BallShooter. */
  
    public BallShooter(ShootingSystem subsystem) {
      m_shootingsystem = subsystem;
      addRequirements(m_shootingsystem);
      
    }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Since our balls velocity will most likely be decided through math from the distance measured by the limelight,
    // we should probably make another command(?) where we take the distance from the limelight and do all the math.
    // Then here, we can just take the value from that and pass it to the shooting subsystem.
    m_shootingsystem.shoot(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
