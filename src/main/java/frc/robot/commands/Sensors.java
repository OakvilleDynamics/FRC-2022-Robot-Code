// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLight;

public class Sensors extends CommandBase {

  //private final DistanceSensorLong m_sensorlong; 
  private final LimeLight m_limelight;

   /** Creates a new Sensors. */
  // public Sensors(DistanceSensorLong subsystem) {
  //   m_sensorlong = subsystem;
  //   addRequirements(m_sensorlong);
  // }
  public Sensors(LimeLight subsystem) {
    m_limelight = subsystem;
    addRequirements(m_limelight);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println("please god print something");
    // System.out.println(m_sensorlong.getDistance());
    // System.out.println("Distance should be above");
    m_limelight.tstuff();
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
