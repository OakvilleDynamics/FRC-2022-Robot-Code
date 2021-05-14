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

    /** Creates a new Combine. */
    public Combine(CombineSystem subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_Combine = subsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    /*s@Override
    public void execute() {
        private boolean xPressed = controller.getXButtonPressed();
        private boolean xReleased = controller.getXButtonReleased();

        if (xPressed = true) {
            combineOn = true;
        }
        if (xReleased = true) {
            combineOn = false;
        }

        if (combineOn = true) {
            m_Combine.
        }

        if (combineOn = false) {
            // combineMotor.set(0);
        }

    }*/

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // combineMotor.set(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}