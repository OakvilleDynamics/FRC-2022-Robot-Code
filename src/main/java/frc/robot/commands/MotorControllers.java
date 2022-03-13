package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

// Was going to put controllers into one commandbase, but motor controllers have been moved to the drivetrain subystem and the rest will be moved soon.
// This file will go away soon.
public class MotorControllers extends CommandBase{
    PowerDistribution PDHub = new PowerDistribution(0, ModuleType.kCTRE);
    CANSparkMax shooterController = new CANSparkMax(Constants.controllerID[4], MotorType.kBrushed);
    VictorSPX intakeController = new VictorSPX(Constants.controllerID[5]);
    VictorSPX liftWenchController = new VictorSPX(Constants.controllerID[6]);
    VictorSPX liftTiltController = new VictorSPX(Constants.controllerID[7]);
    VictorSPX clockController = new VictorSPX(Constants.controllerID[8]);
    CANSparkMax leftFrontController = new CANSparkMax(Constants.controllerID[0], MotorType.kBrushed);
    CANSparkMax leftRearController = new CANSparkMax(Constants.controllerID[1], MotorType.kBrushed);
    CANSparkMax rightFrontController = new CANSparkMax(Constants.controllerID[2], MotorType.kBrushed);
    CANSparkMax rightRearController = new CANSparkMax(Constants.controllerID[3], MotorType.kBrushed);
}
