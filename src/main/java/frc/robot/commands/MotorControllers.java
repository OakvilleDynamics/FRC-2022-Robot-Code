package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

// Was going to put controllers into one commandbase, but motor controllers have been moved to the drivetrain subystem and the rest will be moved soon.
// This file will go away soon.
public class MotorControllers extends CommandBase{
    PowerDistribution PDHub = new PowerDistribution(0, ModuleType.kCTRE);
    VictorSPX intakeController = new VictorSPX(Constants.canID[5]);
    VictorSPX liftWenchController = new VictorSPX(Constants.canID[6]);
    VictorSPX liftTiltController = new VictorSPX(Constants.canID[7]);
    VictorSPX clockController = new VictorSPX(Constants.canID[8]);
}
