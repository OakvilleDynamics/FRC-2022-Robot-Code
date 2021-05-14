// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticButton;

public class ButtonPress extends CommandBase {

    private final PneumaticButton m_PneumaticButton;

    private XboxController auxController = new XboxController(1);

    /** Creates a new ButtonPress. */
    public ButtonPress(PneumaticButton subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_PneumaticButton = subsystem;
        addRequirements(m_PneumaticButton);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (auxController.getYButtonPressed()) {
            m_PneumaticButton.extend();
            System.out.println("Pneumatic Button Press extended!");
        } else {
            m_PneumaticButton.retract();
            System.out.println("Pneumatic Button Press retracted!");
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_PneumaticButton.retract();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
