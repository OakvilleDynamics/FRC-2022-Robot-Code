// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;

public class PneumaticButton extends SubsystemBase {

    private Solenoid buttonSol;

    /** Creates a new PneumaticButton. */
    public PneumaticButton() {
        buttonSol = new Solenoid(1);
        addChild("ButtonSol", buttonSol);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Extends the solenoid for the button press
    public void extend() {
        buttonSol.set(true);
    }

    // Retracts the soleniod for the button press
    public void retract() {
        buttonSol.set(false);
    }
}
