// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticButton extends SubsystemBase {

    private final Solenoid buttonSol;

    /**
     * Creates a new PneumaticButton.
     */
    public PneumaticButton() {
        buttonSol = new Solenoid(Constants.buttonrSolenoidPort);
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
        System.out.println("Pneumatic Button Press extended!");
    }

    // Retracts the solenoid for the button press
    public void retract() {
        buttonSol.set(false);
        System.out.println("Pneumatic Button Press retracted!");
    }
}
