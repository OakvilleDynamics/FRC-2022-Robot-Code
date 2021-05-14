// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CombineSystem;

public class Combine extends CommandBase {
  private final CombineSystem m_Combine;

  private XboxController controller = new XboxController(1);
  private boolean combineOn = false; 
  private boolean xPressed = controller.getXButtonPressed();
  private boolean xReleased = controller.getXButtonReleased();
  

  /** Creates a new Combine. */
  public Combine(CombineSystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Combine = subsystem;

  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  if (xPressed = true ){
    combineOn = true;
    }
  if (xReleased = true){
      combineOn = false;
    }
  if (combineOn = true){
    m_Combine.setSpeed(0.1);
  }

  if (combineOn = false){
    m_Combine.setSpeed(0);
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
