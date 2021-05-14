// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AirCompressor;
import frc.robot.subsystems.RampSystem;

public class Ramp extends CommandBase {

    private final RampSystem m_RampSystem;
    private final AirCompressor m_AirCompressor = new AirCompressor();

    private XboxController auxController = new XboxController(Constants.auxControllerPort);

    /** Creates a new Ramp. */
    public Ramp(RampSystem subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_RampSystem = subsystem;
        addRequirements(m_RampSystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_AirCompressor.startAirCompressor();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (auxController.getAButtonPressed()) {
            m_RampSystem.extend();
        } else {
            m_RampSystem.retract();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_RampSystem.retract();
        m_AirCompressor.stopAirCompressor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
