// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/* 
Extend the elevator using the lift winch motor, past the rod
Rotate the lift tilt motor 
Shorten the elevator to grab the rod
Rotate back to normal position
*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbingSystem extends SubsystemBase {

  // Init elevator motors
  VictorSPX liftWench = new VictorSPX(Constants.canID[5]);
  VictorSPX liftTilt = new VictorSPX(Constants.canID[6]);
  Servo clampServo = new Servo(0);
  Servo elevatorServo = new Servo(1);
  Servo testServo = new Servo(2);
  //clampServo.kDefaultMaxServoPWM(3.3);
  


  double clampServoAngle;
  double elevatorServoAngle;
  double testServoAngle;

  /** Creates a new ClimbingSystem. */
  public ClimbingSystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb(double leftY, double rightY) {
    // 0.25 axis deadzone both ways
    // 0.3 multiplier is for safety purposes right now
    if (leftY > 0.25) { // Left stick up - Extend elevator
      liftWench.set(ControlMode.PercentOutput, leftY);
    }

    if (leftY < -0.25) { // Left stick downward - Retract elevator
      liftWench.set(ControlMode.PercentOutput, leftY);
    }

    if (leftY > -0.25 && leftY < 0.25) {
      liftWench.set(ControlMode.Velocity, 0);
    }

    if (rightY > 0.25) { // Right stick up - Rotate elevator outward
      liftTilt.set(ControlMode.PercentOutput, rightY*0.5);
    }

    if (rightY < -0.25) { // Right stick down - Rotate elevator inward
      liftTilt.set(ControlMode.PercentOutput, rightY*0.5);
    }

    if (rightY > -0.25 && rightY < 0.25) {
      liftTilt.set(ControlMode.Velocity, 0);
    }
  }

  public void openClamp(boolean trigger) {
    if (trigger) {
      clampServo.set(1);
    }
  }

  public void closeClamp(boolean trigger) {
    if (trigger) {
      clampServo.set(0);
    }
  }


  /* public void openServo(boolean trigger) {
    if (trigger) {
      elevatorServo.set(0.3);
    }
  }

  public void closeServo(boolean trigger) {
    if (trigger) {
      elevatorServo.set(0.4);
    }
  }
  
  public void stopServo(boolean trigger) {
    if (trigger) {
      elevatorServo.setSpeed(0);
    }
  } */

  public void getServos() {
    clampServo.getRaw();
    SmartDashboard.putNumber("raw serv", clampServo.getRaw());  
    clampServoAngle = clampServo.get();
    elevatorServoAngle = elevatorServo.getAngle();
    testServoAngle = testServo.getAngle();
    SmartDashboard.putNumber("Clamp Servo", clampServoAngle);
    SmartDashboard.putNumber("Elevator Servo", elevatorServoAngle);
    SmartDashboard.putNumber("test ser", testServoAngle);
    SmartDashboard.putData(clampServo);
    SmartDashboard.putData(elevatorServo);
    SmartDashboard.putData(testServo);
  }
}
