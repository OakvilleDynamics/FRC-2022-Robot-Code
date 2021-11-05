// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CombineSystem extends SubsystemBase {

  private final PWMTalonSRX combineMotor;

  /** Creates a new Combine. */
  public CombineSystem() {
    combineMotor = new PWMTalonSRX(Constants.combineMotorPort);
    addChild("CombineMotor", combineMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation

  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Sets the combine to start and run at a constant value
  public void combineStart() {
    combineMotor.set(Constants.combineLimit);
    System.out.println("Combine started!");
  }

  public void combineStop() {
    combineMotor.stopMotor();
    System.out.println("Combine stopped!");
  }

  public void combineStartR() {
    combineMotor.set(-Constants.combineLimit);
    System.out.println("Combine started!");
  }

  public void combineTest() {
    System.out.println("Combine should be working");
  }

    public void rampTestOff() {
        System.out.println("CombineSystem Interrupted ");
    }

}
