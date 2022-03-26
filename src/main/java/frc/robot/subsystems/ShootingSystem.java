// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSystem extends SubsystemBase {

  // Init shooter + clock motor
  private final CANSparkMax shooterMotor;
  private final VictorSPX clockMotor;

  // Init Power Distribution Panel
  private final PowerDistribution powerDistribution;

  // Init line followers
  private final AnalogInput bottomLine;
  private final AnalogInput topLine;

  /** Creates a new ShootingSystem. */
  public ShootingSystem() {

    // Assign devices
    shooterMotor = new CANSparkMax(Constants.canID[4], MotorType.kBrushed);
    shooterMotor.setInverted(false);

    clockMotor = new VictorSPX(Constants.canID[8]);

    powerDistribution = new PowerDistribution(Constants.pdpCID, ModuleType.kCTRE);

    topLine = new AnalogInput(1);
    bottomLine = new AnalogInput(0);
  }

  // Ball shooting method
  public void shootPrep(double shootSpeed) {
    double mSpeed = ((shootSpeed * -1) + 1) / 2;
    shooterMotor.set(mSpeed);
  }

  public void stopPrep() {
    shooterMotor.stopMotor();
  }

  public void clock() {
    clockMotor.set(ControlMode.PercentOutput, 0.5); // normal speed before ball resistance
    if (powerDistribution.getCurrent(0) > 5) { // if more amperage is used to move the motor
      clockMotor.set(ControlMode.PercentOutput, 0.2); // slow down motor
      if (topLine.getValue() > 0 && bottomLine.getValue() > 0) { // if line followers see that ball in middle
        clockMotor.set(ControlMode.PercentOutput, 0); // stop motor
      }
    }
  }

  public void shoot() { // Move ball to shoot using clock motor
    clockMotor.set(ControlMode.PercentOutput, 0.1);
  }

  public void reject() {
    clockMotor.set(ControlMode.PercentOutput, -0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
