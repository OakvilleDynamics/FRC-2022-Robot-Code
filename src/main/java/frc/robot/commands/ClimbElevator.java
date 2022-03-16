// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Jason's Controller Preference for now:
/*
Right trigger - Intake in
Left trigger - Intake out
Right bumper - Set shooter motor to required speed
Left bumper - Stop shooter motor
Left stick up - Extend elevator
Left stick down - Retract elevator
Right stick up/down - Rotate elevator inward/outward
*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbingSystem;

public class ClimbElevator extends CommandBase {

  private final XboxController auxController =
      new XboxController(Constants.auxControllerPort);

  private final ClimbingSystem m_climbingsystem;

  /** Creates a new ClimbElevator. */
 public ClimbElevator(ClimbingSystem subsystem) {
    m_climbingsystem = subsystem;
    addRequirements(m_climbingsystem);
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

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
