// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.util.Color;

import  com.revrobotics.ColorSensorV3;


public class ColorSensor extends SubsystemBase {
  /** Creates a new ColorSensor. */ 
  final I2C.Port i2cPort = I2C.Port.kOnboard;
    
  final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Color detectedColor = m_colorSensor.getColor();
    int proximity = m_colorSensor.getProximity();

    System.out.print("Red: " + detectedColor.red);
    System.out.print("Green: " + detectedColor.green);
    System.out.print("Blue: " + detectedColor.blue);
    System.out.print("Proximity: " + proximity);

  }
}
