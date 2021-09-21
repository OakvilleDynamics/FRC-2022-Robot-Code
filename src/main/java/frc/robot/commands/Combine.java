// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.CombineSystem;

public class Combine extends CommandBase {
    private final CombineSystem m_Combine;

    private final XboxController auxController = new XboxController(Constants.auxControllerPort);
    private final boolean combineOn = false;

    // Creates a new Combine.
    public Combine(CombineSystem subsystem) {
        m_Combine = subsystem;
        addRequirements(m_Combine);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_Combine.combineTest();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // If the X button is pressed on the auxController
        if (auxController.getXButton()) {
            m_Combine.combineStart();
            System.out.println("XButton Pressed");
        } else if (auxController.getBButton()) {
            m_Combine.combineStartR();
            System.out.println("BButton Pressed");
        } else {
            System.out.println("combine stopped");
            m_Combine.combineStop();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_Combine.rampTestOff();
        m_Combine.combineStop();
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