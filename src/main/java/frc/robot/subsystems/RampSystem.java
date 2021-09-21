// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RampSystem extends SubsystemBase {

    private final Solenoid rampSol;

    /** Creates a new RampSystem. */
    public RampSystem() {
        rampSol = new Solenoid(Constants.rampSolenoidPort);
        addChild("RampSol", rampSol);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // Extends the solenoid for the ramp ramp
    public void extend() {
        rampSol.set(true);
        System.out.println("Pneumatic Ramp extended!");
    }

    // Retracts the soleniod for the ramp
    public void retract() {
        rampSol.set(false);
        System.out.println("Pneumatic Ramp retracted!");
    }

    public void rampTest() {
        System.out.println(rampSol.get());
    }

}
