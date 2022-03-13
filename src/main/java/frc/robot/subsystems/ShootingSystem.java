// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.BallShooter;
import frc.robot.commands.CANSparkMaxSendable;
import frc.robot.subsystems.BallVelocity;

public class ShootingSystem extends SubsystemBase {

  // Init shooter motor
  private final CANSparkMaxSendable shooterMotor;

  

  /** Creates a new ShootingSystem. */
  public ShootingSystem() {
    // Assign motor
    shooterMotor = new CANSparkMaxSendable(Constants.controllerID[5], MotorType.kBrushed);
    addChild("Shooter", shooterMotor);
    shooterMotor.setInverted(false);
  }

  // Ball shooting method
  public void shoot() {

    // Get distance from limelight - NOT IMPLEMENTED

    // Get best velocity from distance
    // First 0 is placeholder for distance
    double ballVelocity = BallVelocity.final_vr(0, 25, 0, 150);

    // Turn the velocity the ball needs to go into the velocity the motor needs to shoot the ball at somehow - NOT IMPLEMENTED
    double shootSpeed = ballVelocity * 1;

    // Set motor velocity to the required velocity for a period of time
    // Garrett said something about being able to measure motor resistance; maybe that could be used to see when the ball is past the motor?
    shooterMotor.set(shootSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
