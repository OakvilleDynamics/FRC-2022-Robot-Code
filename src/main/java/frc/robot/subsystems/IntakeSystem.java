package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSystem extends SubsystemBase {
    
    // Init intake motor
    VictorSPX intake = new VictorSPX(Constants.canID[7]);

    public IntakeSystem() {}

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    public void in() {
        intake.set(ControlMode.PercentOutput, 0.3);
    }

    public void out() {
        intake.set(ControlMode.PercentOutput, 0.3);
    }
}
