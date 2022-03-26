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
    // Since our balls velocity will most likely be decided through math from the distance measured by the limelight,
    // we should probably make another command(?) where we take the distance from the limelight and do all the math.
    // Then here, we can just take the value from that and pass it to the shooting subsystem.

    if (auxController.getRightBumper() == true) { // Set shooting motor to the speed we want whenever right bumper is pressed
      m_shootingsystem.shootPrep();
    }

    if (auxController.getLeftBumper() == true) { // Stop shooting motor when left bumper pressed
      m_shootingsystem.stopPrep();
    }

    if (driverController.getTrigger() == true) { // Move clock motor and shoot ball when trigger on joystick is pressed
      m_shootingsystem.shoot();
    }

    if (driverController.getRawButton(2) == true) {
      m_shootingsystem.clock();
    }
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
