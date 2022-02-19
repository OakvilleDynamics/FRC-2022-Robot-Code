// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

public class DistanceSensorLong extends SubsystemBase {

  public AnalogInput sharp;
  
  /** Creates a new DistanceSensorLong. */
  public DistanceSensorLong() {
sharp = new AnalogInput(0);
  }
  

  public double getDistance()
{
  System.out.println(sharp.getVoltage());
  return (Math.pow(sharp.getAverageVoltage(), -1.2045)) * 27.726;
}


  @Override
  public void periodic() {
   
  }
}
