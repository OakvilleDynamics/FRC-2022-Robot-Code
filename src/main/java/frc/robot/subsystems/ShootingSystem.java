// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSystem extends SubsystemBase {

  // Init shooter + clock motor
  private final CANSparkMax shooterMotor;
  private final VictorSPX clockMotor;

  // Init encoders
  private final RelativeEncoder shooterEncoder;

  // Init Power Distribution Panel
  private final PowerDistribution powerDistribution;

  // Init line followers
  private final AnalogInput bottomLine;
  private final AnalogInput topLine;

  // Init intake motor
  VictorSPX intake = new VictorSPX(Constants.canID[7]);


  boolean toggle;
  boolean atMax;
  public double mSpeed;
  double clockMotorSet;
  double intakeMotorSet;
  double startShootTimer;
  double shootMethod;
  

  /** Creates a new ShootingSystem. */
  public ShootingSystem() {

    // Assign devices
    shooterMotor = new CANSparkMax(Constants.canID[4], MotorType.kBrushed);
    shooterMotor.setInverted(false);

    clockMotor = new VictorSPX(Constants.canID[8]);
    clockMotor.setInverted(true);

    powerDistribution = new PowerDistribution(Constants.pdpCID, ModuleType.kCTRE);

    topLine = new AnalogInput(1);
    addChild("topLine", topLine);
    bottomLine = new AnalogInput(0);
    addChild("bottomLine", bottomLine);

    shooterEncoder = shooterMotor.getAlternateEncoder(Type.kQuadrature, 8192);

    double clockAmperage = powerDistribution.getCurrent(0);
    SmartDashboard.putNumber("Clock Motor Amperage", clockAmperage);
  }

  // Ball shooting method
  public void shootPrep(boolean aButton, boolean bButton, boolean xButton, boolean yButton) {

    if (aButton) {
      mSpeed = 0.25;
    } else if (xButton) {
      mSpeed = 0.5;
    } else if (yButton) {
      mSpeed = 0.75;
    } else if (bButton) {
      mSpeed = 1;
    } else {
      mSpeed = 0;
    }

    SmartDashboard.putNumber("Shoot Speed", mSpeed);
    shooterMotor.set(mSpeed);
  }

  public void clock(boolean trigger) {
    if (trigger) {
      clockMotor.set(ControlMode.PercentOutput, 0.25);
      toggle = true;
    }
    if (toggle) {
      clockMotor.set(ControlMode.PercentOutput, 0);
      toggle = false;
    }
  }

  public void shoot(boolean trigger) { // Move ball to shoot using clock motor
  
    if (trigger) {
      startShootTimer = System.currentTimeMillis();
      clockMotor.set(ControlMode.PercentOutput, -0.25);
      shootMethod = -0.25;
      toggle = true;
    }
    if (toggle == true) {
      if (System.currentTimeMillis() - startShootTimer > 500) {
        clockMotor.set(ControlMode.PercentOutput, 1);
        shootMethod = 1;
      }
      if (System.currentTimeMillis() - startShootTimer > 1500) {
        clockMotor.set(ControlMode.PercentOutput, 0);
        shootMethod = 0;
        toggle = false;
      }
    }
    SmartDashboard.putNumber("Shoot Method", shootMethod);
  }

  public void shoot(boolean triggerState, double leftTrigger, double rightTrigger) { // Move ball to shoot using clock motor
    if (triggerState) {
      clockMotor.set(ControlMode.PercentOutput, 0.25);
    } else if (leftTrigger < 0.25 && rightTrigger < 0.25) {
      clockMotor.set(ControlMode.PercentOutput, 0);
    }
  }
  public void clockSet(double cSpeed) {
    clockMotor.set(ControlMode.PercentOutput, cSpeed);
    SmartDashboard.putNumber("clockMotorSet", cSpeed);
  }

 public void intake(double leftTrigger, double rightTrigger, boolean button, boolean triggerState) {
        
  if (leftTrigger > 0.25) {
      intake.set(ControlMode.PercentOutput, -1);
      clockMotor.set(ControlMode.PercentOutput, 0.25);
      intakeMotorSet = 0.25;
  } else if (rightTrigger > 0.25) {
      intake.set(ControlMode.PercentOutput, 1);
      clockMotor.set(ControlMode.PercentOutput, 0.25);
      intakeMotorSet = 0.25;
  } else if (!triggerState) {
      intake.set(ControlMode.PercentOutput, 0);
      clockMotor.set(ControlMode.PercentOutput, 0);
      intakeMotorSet = 0;
  }
  SmartDashboard.putNumber("intakeMotorSet", intakeMotorSet);
}

  public void reject(boolean rejectState) {
    if (rejectState) {
      clockMotor.set(ControlMode.PercentOutput, -0.5);
    } else {
      clockMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public void shooterCheck(boolean aButton, boolean bButton, boolean xButton, boolean yButton) {

    double sSpeed;

    if (aButton) {
      sSpeed = 0.25;
    } else if (xButton) {
      sSpeed = 0.5;
    } else if (yButton) {
      sSpeed = 0.75;
    } else if (bButton) {
      sSpeed = 1;
    } else {
      sSpeed = 0;
    }

    double shooterVelocity = shooterEncoder.getVelocity();
    SmartDashboard.putNumber("Shooter Encoder Velocity", shooterVelocity);

    double maxSpeed = sSpeed * 10;

    if (shooterVelocity > maxSpeed) {
      atMax = true;
    } else {
      atMax = false;
    }
    
    SmartDashboard.putBoolean("Shooter Check", atMax);
  }

  public void autoIntake(double speed) {
    intake.set(ControlMode.PercentOutput, speed);
  }

  public void autoShootMotor(double speed) {
    shooterMotor.set(speed);
  }

  public void autoShoot(boolean trigger) { // Move ball to shoot using clock motor
    if (trigger) {
        startShootTimer = System.currentTimeMillis();
        clockMotor.set(ControlMode.PercentOutput, -0.25);
        toggle = true;
    }
    if (toggle) {
        if (System.currentTimeMillis() - startShootTimer > 500) {
            clockMotor.set(ControlMode.PercentOutput, 1);
        }
        if (System.currentTimeMillis() - startShootTimer > 1500) {
            clockMotor.set(ControlMode.PercentOutput, 0);
            toggle = false;
        }
    }
  }

  public void autoClock(double speed) {
    clockMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
