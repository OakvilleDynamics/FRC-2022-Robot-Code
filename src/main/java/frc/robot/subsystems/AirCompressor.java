// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AirCompressor extends SubsystemBase {

    private Compressor airComp;

    /** Creates a new AirCompressor. */
    public AirCompressor() {
        airComp = new Compressor(Constants.airCompressorPort);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void startAirCompressor() {
        airComp.setClosedLoopControl(true);
        System.out.println("Started Air Compressor!");
    }

    public void stopAirCompressor() {
        airComp.stop();
        System.out.println("Stopped Air Compressor!");
    }

    public void getAirCompressorStatus(){
        System.out.print("Air Compressor Status: " + airComp.enabled());
    }

    public void getAirCompressorCurrent(){
        System.out.println("Air Compressor Current: " + airComp.getCompressorCurrent());
    }
}
