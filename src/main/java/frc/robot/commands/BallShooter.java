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

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingSystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class BallShooter extends CommandBase {

  private final ShootingSystem m_shootingsystem;
  /** Creates a new BallShooter. */
  
  private final Joystick driverController = new Joystick(Constants.driverControllerPort);
  private final XboxController auxController = new XboxController(Constants.auxControllerPort);

  

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

    // Set shooting motor to the speed we want whenever right bumper is pressed
    m_shootingsystem.shootPrep(auxController.getAButton(), auxController.getBButton(), auxController.getXButton(), auxController.getYButton());

    m_shootingsystem.shoot(driverController.getTrigger(), auxController.getRawAxis(2), auxController.getRawAxis(3));

    m_shootingsystem.clock(driverController.getRawButtonPressed(2));

    m_shootingsystem.reject(driverController.getRawButton(3));

    m_shootingsystem.shooterCheck(auxController.getAButton(), auxController.getBButton(), auxController.getXButton(), auxController.getYButton());

    m_shootingsystem.intake(auxController.getRawAxis(2), auxController.getRawAxis(3), auxController.getAButton(), driverController.getTrigger());
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
